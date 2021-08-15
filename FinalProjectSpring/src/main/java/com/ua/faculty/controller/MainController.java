package com.ua.faculty.controller;

import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import com.ua.faculty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private CourseRepository courseRepository;

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index(Model model) {
       Iterable<Course> courses = courseRepository.findAll();
       model.addAttribute("courses", courses);
       return "index";
   }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {
       return "login";
   }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

}
