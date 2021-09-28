package com.example.faculty.servlet.pages;

import com.example.faculty.model.service.CourseService;
import com.example.faculty.model.service.ServiceFactory;
import com.example.faculty.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePage implements Page {

    public CourseService courseService;
    public UserService userService;

    @Override
    public void get(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        courseService = serviceFactory.createCourseService();
        request.setAttribute("courses", courseService.getAllCourses());
        request.setAttribute("users", courseService.getAllCourses()
                                            .stream()
                                            .map(course -> userService
                                                    .getStudentsByCourseId(course.getId())));
        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
