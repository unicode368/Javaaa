package com.ua.faculty.controller;

import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Головна");
        return "login";
    }

    //private final LoginService loginService;

    /*@Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }*/

    /*@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void loginFormController(UserDTO user){
        log.info("{}", user);
    }*/

}

