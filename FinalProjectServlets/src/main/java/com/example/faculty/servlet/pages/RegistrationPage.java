package com.example.faculty.servlet.pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPage implements Page {
    @Override
    public void get(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp")
                .forward(request, response);
    }

    public void post(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {

    }
}
