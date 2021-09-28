package com.example.faculty.model.dao;

import com.example.faculty.model.entity.User;
import com.example.faculty.model.entity.UserInfo;

import java.util.Optional;

public interface UserInfoDAO extends GeneralDAO<UserInfo>{
    String FIND_TEACHER_BY_COURSE_ID =
            "SELECT * FROM user_info\n" +
                    "JOIN teacher_courses ON user_info.user_id=teacher_courses.teacher_id\n" +
                    "WHERE teacher_courses.course_id=?";
    UserInfo findTeacherByCourseId(Long id);
}
