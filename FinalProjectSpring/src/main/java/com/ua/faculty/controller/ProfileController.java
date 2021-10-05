package com.ua.faculty.controller;

import com.ua.faculty.entity.User;
import com.ua.faculty.service.CourseService;
import com.ua.faculty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Authentication authentication, Model model) {
        String role = authentication.getAuthorities()
                .iterator().next().toString();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("info", userService
                .getUserByLogin(user.getLogin()).getUserInfo());
        model.addAttribute("login", userService
                .getUserByLogin(user.getLogin()).getLogin());
        model.addAttribute("localDate", LocalDate.now());
        switch (role) {
            case "user":
                model.addAttribute("courses", courseService
                        .getAllStudentCourses(user.getLogin()));
                model.addAttribute("rates", courseService
                        .getAllStudentGrades(user.getLogin()));
            case "teacher":
                model.addAttribute("teacherCourses", courseService
                        .getAllTeacherCourses(user.getLogin()));
        }
        return "profile";
    }
}
