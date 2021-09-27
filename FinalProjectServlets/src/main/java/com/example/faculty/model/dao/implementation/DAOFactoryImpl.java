package com.example.faculty.model.dao.implementation;

import com.example.faculty.model.dao.*;

public class DAOFactoryImpl extends DAOFactory {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public CourseDAO createCourseDao() {
        return new CourseDAOImpl(connectionPool.getConnection());
    }

    @Override
    public CourseRatingDAO createCourseRatingDao() {
        return null;
    }

    @Override
    public RoleDAO createRoleDao() {
        return null;
    }

    @Override
    public UserDAO createUserDao() {
        return null;
    }

    @Override
    public UserInfoDAO createUserInfoDao() {
        return null;
    }
}
