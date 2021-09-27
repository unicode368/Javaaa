package com.example.faculty.model.dao;

import com.example.faculty.model.dao.implementation.DAOFactoryImpl;

public abstract class DAOFactory {

    private static DAOFactory daoFactory;

    public abstract CourseDAO createCourseDao();

    public abstract CourseRatingDAO createCourseRatingDao();

    public abstract RoleDAO createRoleDao();

    public abstract UserDAO createUserDao();

    public abstract UserInfoDAO createUserInfoDao();

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DAOFactory.class) {
                if (daoFactory == null) {
                    DAOFactory temp = new DAOFactoryImpl();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
