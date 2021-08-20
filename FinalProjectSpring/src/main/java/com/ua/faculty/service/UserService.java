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

    private final UserRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws
            UsernameNotFoundException {
        return userInfoRepository.findByUsername(email)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
