package com.example.faculty.model.dao.implementation;

import com.example.faculty.model.dao.UserDAO;
import com.example.faculty.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findByCourseId(Long id) {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection
                        .prepareStatement(FIND_ALL_STUDENTS_BY_COURSE_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users.add(new User());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void close() {

    }
}
