package com.example.faculty.model.dao;

import com.example.faculty.model.entity.CourseRating;

import java.util.List;

public interface CourseRatingDAO extends GeneralDAO<CourseRating> {
    String FIND_BY_USER_ID = "SELECT courses.id, user_courses.grade\n" +
            "            FROM courses\n" +
            "            JOIN user_courses ON courses.id=user_courses.course_id\n" +
            "            WHERE user_courses.user_id=?";
    List<CourseRating> findAllByUserId(Long id);
}
