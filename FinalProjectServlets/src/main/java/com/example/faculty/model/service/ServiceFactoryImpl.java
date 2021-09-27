package com.example.faculty.model.service;

import com.example.faculty.model.dao.DAOFactory;

public class ServiceFactoryImpl extends ServiceFactory {
    @Override
    public CourseService createCourseService() {
        return new CourseService(DAOFactory.getInstance());
    }
}
