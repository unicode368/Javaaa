package com.ua.faculty.service;

import com.ua.faculty.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public String inputUser(UserDTO name) {
        return "login";
    }
}
