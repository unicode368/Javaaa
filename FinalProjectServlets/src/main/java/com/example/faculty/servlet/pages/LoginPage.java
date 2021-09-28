package com.example.faculty.servlet.pages;

import com.example.faculty.model.service.ServiceFactory;
import com.example.faculty.model.service.UserService;
import com.example.faculty.servlet.validator.LoginValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPage implements Page {
    public UserService userService;

    @Override
    public void get(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        userService = serviceFactory.createUserService();
        switch (LoginValidator.validate(userService,
                request.getParameter("login"),
                request.getParameter("password"))) {
            case "null":
                request.setAttribute("loginError", "wrong.credentials");
                request.getRequestDispatcher("/login.jsp")
                        .forward(request, response);
            case "blocked":
                request.setAttribute("loginError", "user.blocked");
                request.getRequestDispatcher("/login.jsp")
                        .forward(request, response);
            default: break;
        }
        request.getSession().setAttribute("user", userService
                .getUserByCredentials(request.getParameter("login"),
                        request.getParameter("password")));
        response.sendRedirect(request.getContextPath() + "/profile");
    }
}
