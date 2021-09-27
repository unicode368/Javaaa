package com.example.faculty.servlet.pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Page {
    default void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    default void post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    default void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();
        switch (method) {
            case "GET":
                this.get(request, response);
                break;
            case "POST":
                this.post(request, response);
                break;

        }
    }
}
