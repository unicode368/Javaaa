package com.ua.faculty.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "user_id")
    private Long id;
    @Column(name = "login")
    @Length(min = 5, message = "*Your user name must have at least 5 characters")
    @NotEmpty(message = "*Please provide a user name")
    private String login;
    @Column(name = "surname")
    @Length(min = 5, message = "*Your surname must have at least 5 characters")
    @NotEmpty(message = "*Please provide a surname")
    private String surname;
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "patronimic")
    @NotEmpty(message = "*Please provide your name")
    private String patronimic;
    @Column(name = "phone_number")
    @NotEmpty(message = "*Please provide your last name")
    private String phoneNumber;
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    public UserInfo(String login, String surname,
                    String name, String patronimic,
                    String phoneNumber, String email) {
        this.login = login;
        this.surname = surname;
        this.name = name;
        this.patronimic = patronimic;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "gejhjegjhe";
    }
}
