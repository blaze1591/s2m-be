package com.s2mbe.security;

import com.s2mbe.model.user.Credentials;
import com.s2mbe.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        Credentials credentials = user.getCredentials();
        return new JwtUser(
                user.getId(),
                credentials.getUserName(),
                user.getEmail(),
                credentials.getPassword(),
                mapToGrantedAuthorities(credentials)
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Credentials credentials) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(credentials.getRole()));
        return authorities;
    }

}
