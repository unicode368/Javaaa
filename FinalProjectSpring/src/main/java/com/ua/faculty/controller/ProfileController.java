package com.ua.faculty.controller;

import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import com.ua.faculty.repository.UserInfoRepository;
import com.ua.faculty.repository.UserRepository;
import com.ua.faculty.service.CourseService;
import com.ua.faculty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("info", userService
                .getUserByLogin(principal.getName()).getUserInfo());
        model.addAttribute("login", userService
                .getUserByLogin(principal.getName()).getLogin());
        model.addAttribute("courses", courseService
                .getAllStudentCourses(principal.getName()));
        model.addAttribute("rates", courseService
                .getAllStudentGrades(principal.getName()));
        model.addAttribute("localDate", LocalDate.now());
        return "profile";
    }
}
