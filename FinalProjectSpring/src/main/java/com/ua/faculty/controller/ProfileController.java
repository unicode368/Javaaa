package com.ua.faculty.controller;

import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import com.ua.faculty.repository.UserInfoRepository;
import com.ua.faculty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class ProfileController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("info", userRepository
                .findByLogin(principal.getName()).get().getUserInfo());
        model.addAttribute("login", userRepository
                .findByLogin(principal.getName()).get().getLogin());
        return "profile";
    }
}
