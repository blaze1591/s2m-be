package com.s2mbe.controller;

import com.s2mbe.error.InvalidPasswordException;
import com.s2mbe.error.UserAlreadyExistsException;
import com.s2mbe.error.UserNotFoundException;
import com.s2mbe.model.user.User;
import com.s2mbe.security.JwtAuthenticationRequest;
import com.s2mbe.security.JwtAuthenticationResponse;
import com.s2mbe.security.JwtUser;
import com.s2mbe.security.JwtUtil;
import com.s2mbe.service.UserService;
import com.s2mbe.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class AuthController {

    public final static String SIGNUP_URL = "/api/auth/signup";
    public final static String SIGNIN_URL = "/api/auth/signin";
    public final static String ACTIVATE_URL = "/api/auth/activate/";
    public final static String REFRESH_TOKEN_URL = "/api/auth/token/refresh";
    @Autowired
    UserServiceImpl userServiceImpl;
    @Value("${auth.header}")
    private String tokenHeader;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private UserDetailsService userDetailsService;
    private UserService userService;

    /**
     * Injects AuthenticationManager instance
     *
     * @param authenticationManager to inject
     */
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Injects JwtUtil instance
     *
     * @param jwtUtil to inject
     */
    @Autowired
    public void setJwtTokenUtil(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * Injects UserDetailsService instance
     *
     * @param userDetailsService to inject
     */
    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Injects UserServiceImpl instance
     *
     * @param userService to inject
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Adds new user and returns authentication token
     *
     * @param authenticationRequest request with username, email and password fields
     * @return generated JWT
     * @throws AuthenticationException
     */
    @PostMapping(SIGNUP_URL)
    public ResponseEntity createAuthenticationToken(@RequestBody User authenticationRequest)
            throws Exception {

        final String name = authenticationRequest.getCredentials()
                .getUserName();
        final String email = authenticationRequest.getEmail();
        final String password = authenticationRequest.getCredentials()
                .getPassword();

        if (this.userService.findByName(name) != null) {
            throw new UserAlreadyExistsException();
        }

        if (this.userService.findByEmail(email) != null) {
            throw new UserAlreadyExistsException();
        }
        JwtUser userDetails;

        userServiceImpl.save(authenticationRequest);

        try {
            userDetails = (JwtUser) userDetailsService.loadUserByUsername(name);
        } catch (UsernameNotFoundException ex) {
            throw new UserNotFoundException();
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(name, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    /**
     * Returns authentication token for given user
     *
     * @param authenticationRequest with username and password
     * @return generated JWT
     * @throws AuthenticationException
     */
    @PostMapping(SIGNIN_URL)
    public ResponseEntity getAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
            throws AuthenticationException {

        final String name = authenticationRequest.getUsername();
        final String password = authenticationRequest.getPassword();
        JwtUser userDetails;

        try {
            userDetails = (JwtUser) userDetailsService.loadUserByUsername(name);
        } catch (UsernameNotFoundException | NoResultException ex) {
            throw new UserNotFoundException();
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }

        if (!passwordEncoder().matches(password, userDetails.getPassword())) {
            throw new InvalidPasswordException();
        }

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(name, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    /**
     * Refreshes token
     *
     * @param request with old JWT
     * @return Refreshed JWT
     */
    @PostMapping(REFRESH_TOKEN_URL)
    public ResponseEntity refreshAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = jwtUtil.refreshToken(token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
    }

    @GetMapping(ACTIVATE_URL + "{registrationToken}")
    public  ResponseEntity<User> activateUser(@PathVariable String registrationToken) {
        User user = userServiceImpl.activateUser(registrationToken);
        return ResponseEntity.ok(user);
    }
}
