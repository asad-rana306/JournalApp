package net.engineeringdigest.journalApp.repository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetails {
    org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
// org.springframework.security.core.userdetails.User