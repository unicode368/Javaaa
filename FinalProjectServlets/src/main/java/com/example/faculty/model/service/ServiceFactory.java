package com.example.faculty.model.service;

public abstract class ServiceFactory {
    private static ServiceFactory serviceFactory;


    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    serviceFactory = new ServiceFactoryImpl();
                }
            }
        }
        return serviceFactory;
    }

    public abstract CourseService createCourseService();

}
