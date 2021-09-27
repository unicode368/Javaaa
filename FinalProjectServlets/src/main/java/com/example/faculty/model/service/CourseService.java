package com.example.faculty.model.service;

import com.example.faculty.model.dao.CourseDAO;
import com.example.faculty.model.dao.DAOFactory;
import com.example.faculty.model.entity.Course;

import java.util.List;

public class CourseService {
    private final DAOFactory daoFactory;

    public CourseService(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Course> getAllCourses() {
        try (CourseDAO courseDao = daoFactory.createCourseDao()) {
            return courseDao.findAll();
        }
    }
}
