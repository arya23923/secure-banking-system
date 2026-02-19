package com.arya.banking.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Temporary dummy user
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password("{noop}password")
                .roles("USER")
                .build();
    }
}