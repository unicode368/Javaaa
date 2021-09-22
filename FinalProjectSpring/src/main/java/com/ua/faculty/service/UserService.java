package com.ua.faculty.service;

import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import com.ua.faculty.exceptions.UserAlreadyExistsException;
import com.ua.faculty.repository.RoleRepository;
import com.ua.faculty.repository.UserInfoRepository;
import com.ua.faculty.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<User> getTeachers() {
        return userRepository.findAllByRoles(roleRepository
                .findByName("teacher")
                        .orElseThrow(() -> new UsernameNotFoundException("")))
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

}
