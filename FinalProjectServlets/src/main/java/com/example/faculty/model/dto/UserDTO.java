package com.example.faculty.model.dto;

public class UserDTO {
    private String surname;
    private String name;
    private String patronimic;
    private String login;
    private String phoneNumber;
    private String email;

    private String password;
    private String matchingPassword;

    public UserDTO(String surname, String name,
                   String patronimic, String login,
                   String phoneNumber, String email,
                   String password, String matchingPassword) {
        this.surname = surname;
        this.name = name;
        this.patronimic = patronimic;
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronimic() {
        return patronimic;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }
}
