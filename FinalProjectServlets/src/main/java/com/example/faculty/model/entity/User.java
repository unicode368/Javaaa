package com.example.faculty.model.entity;

import java.util.stream.Collectors;


public class User {

    private Long id;

    private String login;

    private String password;

    private Boolean blocked;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.blocked = false;
    }


    public String getUsername() {
        return login;
    }

    public boolean isAccountNonLocked() {
        return !blocked;
    }

    @Override
    public String toString() {
       return "id: " + id + "," +
               "login: " + login + "," +
               "password: " + password;
    }
}