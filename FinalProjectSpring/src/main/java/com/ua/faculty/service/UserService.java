package com.ua.faculty.service;

import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import com.ua.faculty.repository.UserInfoRepository;
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
    private final UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws
            UsernameNotFoundException {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public String signUpUser(User user, UserInfo userInfo) {
        userRepository.save(user);
        userInfoRepository.save(userInfo);
        return "reg done";
    }

}
