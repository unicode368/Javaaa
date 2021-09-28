package com.example.faculty.servlet.pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherRegistrationPage implements Page{
    @Override
    public void get(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/create-teacher.jsp")
                .forward(request, response);
    }
}
