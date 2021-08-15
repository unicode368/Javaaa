package com.ua.faculty.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "course_name")
    @Length(min = 5, message = "*Your login must have at least 5 characters")
    @NotEmpty(message = "*Please provide your login")
    private String name;
    @Column(name = "theme")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String theme;
    @Column(name = "info")
    private String info;
    @Column(name = "start_date")
    @NotEmpty
    private Boolean startDate;
    @Column(name = "end_date")
    @NotEmpty
    private Boolean endDate;
}