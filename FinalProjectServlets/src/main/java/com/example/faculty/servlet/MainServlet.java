package com.example.faculty.servlet;

import com.example.faculty.model.exceptions.PageNotFoundException;
import com.example.faculty.model.service.ServiceFactory;
import com.example.faculty.servlet.pages.PageFactory;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/")
public class MainServlet extends HttpServlet {

    private PageFactory pageFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        pageFactory = new PageFactory();
    }

    @Override
    public void service(HttpServletRequest request,
                            HttpServletResponse response)
                                throws ServletException, IOException {
        String uri = request.getRequestURI();
        int i = uri.lastIndexOf("/");
        uri = uri.substring(i);
        try {
            pageFactory.getPage(uri).execute(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (PageNotFoundException e) {
            e.printStackTrace();
        }
    }

}