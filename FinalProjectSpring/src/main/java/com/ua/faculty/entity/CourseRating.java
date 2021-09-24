package com.ua.faculty.entity;

import com.ua.faculty.entity.ids.CourseRatingKey;

import javax.persistence.*;

@Entity
@Table(name = "user_courses")
public class CourseRating {

    @EmbeddedId
    CourseRatingKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    @Column(name = "grade")
    int rating;
}
