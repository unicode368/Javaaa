package com.example.faculty.servlet.pages;

import com.example.faculty.model.entity.Course;
import com.example.faculty.model.service.CourseService;
import com.example.faculty.model.service.ServiceFactory;
import com.example.faculty.model.service.UserInfoService;
import com.example.faculty.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CoursePage implements Page {
    public CourseService courseService;
    public UserService userService;
    public UserInfoService userInfoService;

    @Override
    public void get(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        courseService = serviceFactory.createCourseService();
        userService = serviceFactory.createUserService();
        userInfoService = serviceFactory.createUserInfoService();
        List<Course> courses = courseService.getAllCourses();
        if (request.getParameter("sort") != null) {
            courseService.sort(courses, request.getParameter("sort"));
        }
        request.setAttribute("courses", courses);
        request.setAttribute("users", courses
                .stream()
                .map(course -> userService
                        .getStudentsByCourseId(course.getId()))
                .collect(Collectors.toList()));
        request.setAttribute("teachers", courses
                .stream()
                .map(course -> userInfoService
                        .getTeacherByCourseId(course.getId()))
                .collect(Collectors.toList()));
        request.getRequestDispatcher("/courses.jsp")
                .forward(request, response);
    }
}
