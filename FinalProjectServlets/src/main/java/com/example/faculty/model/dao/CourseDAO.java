package com.example.faculty.model.dao;

import com.example.faculty.model.entity.Course;

import java.util.List;

public interface CourseDAO extends GeneralDAO<Course> {
    String FIND_ALL = "SELECT * FROM courses";
    String FIND_BY_ID = "SELECT * FROM courses WHERE id=?";
    String FIND_BY_THEME = "SELECT * FROM courses WHERE theme=?";
    Course findById(Long id);
    List<Course> findByTheme(String theme);
}
