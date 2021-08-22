package com.ua.faculty.service;

import com.ua.faculty.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws
            UsernameNotFoundException {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
