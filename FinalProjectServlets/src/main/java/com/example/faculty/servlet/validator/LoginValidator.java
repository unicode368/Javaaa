package com.example.faculty.servlet.validator;

import com.example.faculty.model.entity.User;
import com.example.faculty.model.service.UserService;

public class LoginValidator {
    public static String validate(UserService userService,
                                   String login, String password) {
        User user = userService.getUserByCredentials(login, password);
        if (user != null) {
            if (user.getBlocked()) {
                return "blocked";
            }
        } else {
            return "null";
        }
        return "ok";
    }


}
