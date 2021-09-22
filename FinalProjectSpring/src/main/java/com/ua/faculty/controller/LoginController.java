package com.ua.faculty.controller;

import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/login")
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public String login(@RequestBody UserDTO request) {
        return "";
    }

}

