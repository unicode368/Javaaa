package com.ua.faculty.service;

import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User register(@RequestBody UserDTO request) {
        return userService.signUpUser(new User(
                request.getLogin(),
                        bCryptPasswordEncoder.encode(request.getPassword())),
                new UserInfo(request.getLastName(),
                        request.getFirstName(), request.getPatronimic(),
                        request.getPhoneNumber(), request.getEmail()));
    }
}
