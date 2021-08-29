package com.ua.faculty.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

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
    private LocalDate startDate;
    @Column(name = "end_date")
    @NotEmpty
    private LocalDate endDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_courses",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> teachers;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> users;
}