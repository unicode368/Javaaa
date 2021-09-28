package com.example.faculty.model.entity;

public class UserInfo {

    private Long id;

    private String surname;

    private String name;

    private String patronimic;

    private String phoneNumber;

    private String email;

    public UserInfo(String surname,
                    String name, String patronimic,
                    String phoneNumber, String email) {
        this.surname = surname;
        this.name = name;
        this.patronimic = patronimic;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public UserInfo(String surname,
                    String name, String patronimic) {
        this.surname = surname;
        this.name = name;
        this.patronimic = patronimic;
        this.phoneNumber = "";
        this.email = "";
    }

    public UserInfo(Long id, String surname,
                    String name, String patronimic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronimic = patronimic;
        this.phoneNumber = "";
        this.email = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return surname + " "
                + name.charAt(0) + ". " +
                patronimic.charAt(0) + ".";
    }
}
