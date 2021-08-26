package com.ua.faculty.controller;

import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Controller
public class CoursesController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String index(Model model) {
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("localDate", LocalDate.now());
        return "courses";
    }
}
