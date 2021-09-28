package com.example.faculty.model.entity;

import java.util.stream.Collectors;


public class User {

    private Long id;

    private String login;

    private String password;

    private Boolean blocked;

    private Role role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.blocked = false;
    }

    public User(Long id, String login,
                String password, boolean blocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.blocked = blocked;
    }

    public User() {
        this.login = "";
        this.password = "";
        this.blocked = false;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return login;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public Role getRole() {
        return role;
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

    public void setRole(Role role) {
        this.role = role;
    }
}