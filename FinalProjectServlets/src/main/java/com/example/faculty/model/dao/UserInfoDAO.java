package com.example.faculty.model.dao;

import com.example.faculty.model.entity.User;
import com.example.faculty.model.entity.UserInfo;

import java.util.Optional;

public interface UserInfoDAO extends GeneralDAO<UserInfo>{
    String FIND_TEACHER_BY_COURSE_ID =
            "SELECT * FROM user_info\n" +
                    "JOIN teacher_courses ON user_info.user_id=teacher_courses.teacher_id\n" +
                    "WHERE teacher_courses.course_id=?";
    String FIND_TEACHER_BY_FULL_NAME = "SELECT * FROM (\n" +
            "SELECT DISTINCT user_info.user_id, user_info.surname,\n" +
            "\tuser_info.name, user_info.patronimic, user_info.phone_number,\n" +
            "    user_info.email,\n" +
            "\tuser_info.surname || ' ' ||\n" +
            "LEFT(user_info.name, 1) || '. ' || LEFT(user_info.patronimic, 1) || '.' " +
            "AS full_name FROM user_info\n" +
            "JOIN teacher_courses ON user_info.user_id=teacher_courses.teacher_id) teachers\n" +
            "WHERE full_name=?";
    UserInfo findTeacherByCourseId(Long id);
    UserInfo findTeacherByFullName(String fullName);
}
