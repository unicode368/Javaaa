package com.example.faculty.model.dao;

import com.example.faculty.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends GeneralDAO<User> {
    String FIND_ALL_STUDENTS_BY_COURSE_ID =
            "SELECT * FROM user_courses WHERE course_id=?";
    String FIND_BY_CREDENTIALS = "SELECT * FROM users WHERE login=? AND password=?";
    String FIND_ROLE_BY_USER_ID = "SELECT roles.id, roles.role FROM\n" +
            "roles JOIN users_roles ON users_roles.role_id = roles.id\n" +
            "WHERE users_roles.user_id=?";
    List<User> findAllStudentsByCourseId(Long id);
    User findUserByCredentials(String login, String password);
}
