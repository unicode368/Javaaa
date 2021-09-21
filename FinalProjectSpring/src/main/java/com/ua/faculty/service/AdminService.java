package com.ua.faculty.service;

import com.ua.faculty.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class AdminService {

    UserService userService;

    public User changeUserBlockStatus(Long id) {
        return userService.changeBlockStatus(id);
    }
}
