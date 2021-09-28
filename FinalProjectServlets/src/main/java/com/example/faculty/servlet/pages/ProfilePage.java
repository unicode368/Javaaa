package com.example.faculty.servlet.pages;

import com.example.faculty.model.entity.User;
import com.example.faculty.model.service.CourseService;
import com.example.faculty.model.service.ServiceFactory;
import com.example.faculty.model.service.UserInfoService;
import com.example.faculty.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfilePage implements Page{
    public UserService userService;
    public CourseService courseService;
    public UserInfoService userInfoService;

    @Override
    public void get(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        userService = serviceFactory.createUserService();
        courseService = serviceFactory.createCourseService();
        userInfoService = serviceFactory.createUserInfoService();
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("userInfo", userInfoService
                .getUserInfoById(user.getId()));
        if (user.getRole().toString().equals("user")) {
            request.setAttribute("userCourses", courseService
                    .getAllStudentCourses(user.getId()));
        }
        request.getRequestDispatcher("/profile.jsp")
                .forward(request, response);
    }
}
