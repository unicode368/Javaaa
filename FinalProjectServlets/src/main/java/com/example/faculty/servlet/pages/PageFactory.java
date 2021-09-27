package com.example.faculty.servlet.pages;

import com.example.faculty.model.exceptions.PageNotFoundException;

import java.sql.SQLException;

public class PageFactory {
    public Page getPage(String path) throws SQLException, PageNotFoundException {
       // ServiceFactory serviceFactory = ServiceFactory.getInstance();
        switch (path) {
            case "/":
                return new HomePage();
            case "/login":
                return new LoginPage();
            default:
                throw new PageNotFoundException("Request " +
                        "you are looking for not found");
        }
    }
}
