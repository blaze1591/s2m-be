package com.s2mbe.service;

import com.s2mbe.model.User;
import com.s2mbe.repository.UserRepository;
import com.s2mbe.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Finds UserDetails by given username
     *
     * @param username which is used to search user
     * @return UserDetails
     * @throws UsernameNotFoundException if user with given name does not exists
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByCredentialsUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String
                    .format("No user found with username '%s'.", username));
        }
        return JwtUserFactory.create(user);
    }
}
