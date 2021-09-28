package com.example.faculty.model.service;

import com.example.faculty.model.dao.DAOFactory;
import com.example.faculty.model.dao.UserInfoDAO;
import com.example.faculty.model.entity.UserInfo;

import java.util.List;
import java.util.Optional;

public class UserInfoService {
    private final DAOFactory daoFactory;

    public UserInfoService(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public UserInfo getTeacherByCourseId(Long id) {
        try (UserInfoDAO userInfoDao = daoFactory.createUserInfoDao()) {
            return userInfoDao.findTeacherByCourseId(id);
        }
    }

    public UserInfo getUserInfoById(Long id) {
        try (UserInfoDAO userInfoDao = daoFactory.createUserInfoDao()) {
            return userInfoDao.findById(id);
        }
    }
}
