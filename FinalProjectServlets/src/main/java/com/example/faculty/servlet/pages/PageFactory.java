package com.example.faculty.servlet.pages;

import com.example.faculty.model.exceptions.PageNotFoundException;

import java.sql.SQLException;

public class PageFactory {
    public Page getPage(String path) throws SQLException, PageNotFoundException {
        switch (path) {
            case "/home":
                return new HomePage();
            case "/courses":
                return new CoursePage();
            case "/login":
                return new LoginPage();
            case "/registration":
                return new RegistrationPage();
            default:
                throw new PageNotFoundException("Request " +
                        "you are looking for not found");
        }
    }
}
