package com.example.faculty.model.service;

import com.example.faculty.model.dao.DAOFactory;
import com.example.faculty.model.dao.UserDAO;
import com.example.faculty.model.dao.UserInfoDAO;
import com.example.faculty.model.dto.UserDTO;
import com.example.faculty.model.entity.Role;
import com.example.faculty.model.entity.User;
import com.example.faculty.model.entity.UserInfo;
import com.google.common.hash.Hashing;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final DAOFactory daoFactory;

    public UserService(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<User> getStudentsByCourseId(Long id) {
        try (UserDAO userDao = daoFactory.createUserDao()) {
            return userDao.findAllStudentsByCourseId(id);
        }
    }

    public User getUserByCredentials(String login, String password) {
        password = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        try (UserDAO userDao = daoFactory.createUserDao()) {
            return userDao.findUserByCredentials(login, password);
        }
    }

    public User registerUser(UserDTO userDTO) {
        try (UserDAO userDao = daoFactory.createUserDao()) {
            UserInfoDAO userInfoDAO = daoFactory.createUserInfoDao();
            userDao.create(new User());
        }
    }

}
