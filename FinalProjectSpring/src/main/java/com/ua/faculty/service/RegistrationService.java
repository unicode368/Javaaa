package com.ua.faculty.service;

import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public String register(@RequestBody UserDTO request) {
        //TODO: validation and passing data to DB
        return userService.signUpUser(new User(
                request.getLogin(), request.getPassword()),
                new UserInfo(request.getLogin(), request.getLastName(),
                        request.getFirstName(), request.getPatronimic(),
                        request.getPhoneNumber(), request.getEmail()));
    }
}
