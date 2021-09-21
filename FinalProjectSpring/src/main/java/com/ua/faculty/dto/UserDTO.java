package com.ua.faculty.dto;

import com.ua.faculty.validation.PasswordMatches;
import com.ua.faculty.validation.ValidEmail;
import com.ua.faculty.validation.ValidLogin;
import com.ua.faculty.validation.ValidMobilePhone;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@PasswordMatches
public class UserDTO {

    @NotNull
    @NotEmpty
    @ValidLogin
    private String login;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String patronimic;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidMobilePhone
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
}
