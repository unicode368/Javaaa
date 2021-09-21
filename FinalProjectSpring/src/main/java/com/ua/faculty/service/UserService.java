package com.ua.faculty.service;

import com.ua.faculty.entity.Role;
import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import com.ua.faculty.exceptions.UserAlreadyExistsException;
import com.ua.faculty.repository.RoleRepository;
import com.ua.faculty.repository.UserInfoRepository;
import com.ua.faculty.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws
            UsernameNotFoundException {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public User signUpUser(User user, UserInfo userInfo,
                           String roleName) throws UserAlreadyExistsException {
        if (emailOrLoginExists(userInfo.getEmail(), user.getLogin())) {
            throw new UserAlreadyExistsException("");
        }
        user.setRoles(Collections.singleton(roleRepository.findByName(roleName)
                .orElseThrow(() -> new UsernameNotFoundException(""))));
        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        userRepository.save(user);
        userInfoRepository.save(userInfo);
        return user;
    }

    private boolean emailOrLoginExists(String email, String login) {
        return userInfoRepository.findByEmail(email).isPresent()
                || userRepository.findByLogin(login).isPresent();
    }

    public User changeBlockStatus(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(""));
        user.setBlocked(!user.getBlocked());
        userRepository.save(user);
        return user;
    }


}
