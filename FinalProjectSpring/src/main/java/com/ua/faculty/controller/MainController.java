package com.ua.faculty.controller;

import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;*/
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;*/
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
       /* ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;*/
        return "registration";
    }

}
