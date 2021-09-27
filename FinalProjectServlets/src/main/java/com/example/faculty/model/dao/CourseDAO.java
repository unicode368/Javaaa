package com.example.faculty.model.dao;

import com.example.faculty.model.entity.Course;

public interface CourseDAO extends GeneralDAO<Course> {
    String FIND_ALL = "SELECT * FROM courses";
}
