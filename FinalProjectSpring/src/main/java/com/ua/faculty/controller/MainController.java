package com.ua.faculty.controller;

import com.ua.faculty.dto.UserDTO;
import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


@Controller
public class MainController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("localDate", LocalDate.now());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(required = false) String error) {
        if (isAuthenticated()) {
            return "redirect:";
        }
        if (error.equals("true")) {
            model.addAttribute("error", "");
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        if (isAuthenticated()) {
            return "redirect:";
        }
        model.addAttribute("userDTO", new UserDTO());
        return "registration";
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

}
