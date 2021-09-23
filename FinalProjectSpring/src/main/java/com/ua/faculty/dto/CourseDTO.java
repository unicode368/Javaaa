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
public class CourseDTO {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String theme;

    @NotNull
    @NotEmpty
    private String info;

    @NotNull
    @NotEmpty
    private String startDate;
    private String endDate;

    @NotNull
    @NotEmpty
    private String teacher;
}
