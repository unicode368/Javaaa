package com.ua.faculty.controller;

import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import com.ua.faculty.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Lists;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class CoursesController {

    private final CourseRepository courseRepository;

    private final CourseService courseService;

    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public String loadCourses(@RequestParam(value = "sort", required = false)
                            final String sortField,
                        @RequestParam(value = "search-by", required = false)
                        final String searchField,
                              @RequestParam(required = false)
                                  final String searchName, Model model) {
        Iterable<Course> coursesByParameters;
        if (searchField != null) {
            List<Course> courses = new ArrayList<>();
            courseRepository.findAll().forEach(courses::add);
            coursesByParameters = courseService.searchBy(searchField, searchName);
        } else {
            coursesByParameters = courseRepository.findAll();
        }
        if (sortField != null) {
            List<Course> courses = new ArrayList<>();
            coursesByParameters.forEach(courses::add);
            coursesByParameters = courseService.sort(
                    courses, sortField);
        }
        model.addAttribute("courses", coursesByParameters);
        model.addAttribute("localDate", LocalDate.now());
        return "courses";
    }
}
