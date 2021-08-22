package com.ua.faculty.service;

import com.ua.faculty.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(UserDTO request) {
        return "done";
    }
}
