package com.example.faculty.model.dao.implementation;

import com.example.faculty.model.dao.UserInfoDAO;
import com.example.faculty.model.entity.User;
import com.example.faculty.model.entity.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserInfoDAOImpl implements UserInfoDAO {

    private final Connection connection;

    public UserInfoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(UserInfo entity) {

    }

    @Override
    public Optional<UserInfo> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<UserInfo> findAll() {
        return null;
    }

    @Override
    public void update(UserInfo entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public UserInfo findTeacherByCourseId(Long id) {
        UserInfo teacher = null;
        try (PreparedStatement statement = connection
                .prepareStatement(FIND_TEACHER_BY_COURSE_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                teacher = new UserInfo(rs.getString("surname"),
                        rs.getString("name"),
                        rs.getString("patronimic"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return teacher;
    }

    @Override
    public UserInfo findTeacherByFullName(String fullName) {
        UserInfo teacher = null;
        try (PreparedStatement statement = connection
                .prepareStatement(FIND_TEACHER_BY_FULL_NAME)) {
            statement.setString(1, fullName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                teacher = new UserInfo(rs.getLong("user_id"),
                        rs.getString("surname"),
                        rs.getString("name"),
                        rs.getString("patronimic"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return teacher;
    }
}
