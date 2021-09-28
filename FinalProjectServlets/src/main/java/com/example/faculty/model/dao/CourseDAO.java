package com.example.faculty.model.dao;

import com.example.faculty.model.entity.Course;

import java.util.List;

public interface CourseDAO extends GeneralDAO<Course> {
    String FIND_ALL = "SELECT * FROM courses";
    String FIND_BY_ID = "SELECT * FROM courses WHERE id=?";
    String FIND_BY_THEME = "SELECT * FROM courses WHERE theme=?";
    String FIND_BY_TEACHER_ID = "SELECT courses.id, courses.course_name,\n" +
            "courses.theme, courses.info, courses.start_date, courses.end_date\n" +
            "FROM courses\n" +
            "JOIN teacher_courses ON courses.id=teacher_courses.course_id\n" +
            "WHERE teacher_courses.teacher_id=?";
    String FIND_BY_USER_ID = "SELECT courses.id, courses.course_name,\n" +
            "courses.theme, courses.info, courses.start_date, courses.end_date\n" +
            "FROM courses\n" +
            "JOIN user_courses ON courses.id=user_courses.course_id\n" +
            "WHERE user_courses.user_id=?";

    Course findById(Long id);
    List<Course> findByTheme(String theme);
    List<Course> findByTeacherId(Long id);
    List<Course> findByUserId(Long id);
}
