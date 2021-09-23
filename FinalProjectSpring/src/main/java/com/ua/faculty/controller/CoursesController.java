package com.ua.faculty.controller;

import com.ua.faculty.dto.CourseDTO;
import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import com.ua.faculty.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class CoursesController {

    private final CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String loadCourses(@RequestParam(value = "sort", required = false)
                            final String sortField,
                        @RequestParam(value = "search-by", required = false)
                        final String searchField,
                              @RequestParam(required = false) final String searchName, Model model) {
        Iterable<Course> coursesByParameters;
        if (searchField != null) {
            List<Course> courses = new ArrayList<>();
            courseService.getAllCourses().forEach(courses::add);
            coursesByParameters = courseService.searchBy(searchField, searchName);
        } else {
            coursesByParameters = courseService.getAllCourses();
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

    @RequestMapping(value = "/create-course",
            method = RequestMethod.POST)
    public String createNewCourse(@ModelAttribute("courseDTO") CourseDTO course) {
        courseService.createCourse(course);
        return "redirect:/courses";
    }

    @RequestMapping(value = "/admin/courses/{id}/delete",
            method = RequestMethod.POST)
    public String deleteCourse(@PathVariable final String id) {
        courseService.deleteCourse(Long.parseLong(id));
        return "redirect:/courses";
    }


    @RequestMapping(value = "/admin/courses/{id}/edit",
            method = RequestMethod.POST)
    public String editCourse(@PathVariable final String id,
                             @ModelAttribute("courseDTO") CourseDTO course) {
        courseService.editCourse(course, Long.parseLong(id));
        return "redirect:/courses";
    }
}
