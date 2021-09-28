package com.example.faculty.model.dao;

import com.example.faculty.model.entity.Course;

public interface CourseDAO extends GeneralDAO<Course> {
    String FIND_ALL = "SELECT * FROM courses";
    String FIND_BY_ID = "SELECT * FROM courses WHERE id=?";
    Course findById(Long id);
}
