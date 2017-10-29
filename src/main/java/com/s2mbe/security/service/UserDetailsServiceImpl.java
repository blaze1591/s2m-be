package com.s2mbe.security.service;

import com.s2mbe.model.User;
import com.s2mbe.repository.UserRepository;
import com.s2mbe.security.model.SpringSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByCredentialsUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", userName));
        }
        return new SpringSecurityUser(
                user.getId(),
                user.getCredentials().getUserName(),
                user.getCredentials().getPassword(),
                user.getEmail(),
                null,
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getCredentials().getRole()),
                user.getCredentials().getActive()
        );
    }
}
