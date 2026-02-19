package com.arya.banking.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SecurityUtil {

    private SecurityUtil() {
    }

    public static String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return auth.getName();
        }
        return null;
    }

    public static Collection<? extends GrantedAuthority> getCurrentUserAuthorities() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return auth.getAuthorities();
        }
        return null;
    }

    public static boolean hasRole(String role) {
        Collection<? extends GrantedAuthority> authorities = getCurrentUserAuthorities();
        if (authorities != null) {
            return authorities.stream().anyMatch(a -> a.getAuthority().equals(role));
        }
        return false;
    }
}
