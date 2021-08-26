package com.ua.faculty.service;

import com.ua.faculty.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginService {
    public String login(UserDTO request) {
        //TODO: validation
        return "done";
    }
}
