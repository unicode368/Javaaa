package com.example.faculty.model.dao.implementation;

import com.example.faculty.model.dao.UserDAO;
import com.example.faculty.model.entity.Role;
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
    public List<User> findAllStudentsByCourseId(Long id) {
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
        close();
        return users;
    }

    @Override
    public User findUserByCredentials(String login, String password) {
        User user = null;
        try {
            PreparedStatement statement = connection
                    .prepareStatement(FIND_BY_CREDENTIALS);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User(rs.getLong("id"),
                                rs.getString("login"),
                                rs.getString("password"),
                                rs.getBoolean("blocked"));
            }
            if (user != null) {
                Role role = null;
                PreparedStatement roleSt = connection
                        .prepareStatement(FIND_ROLE_BY_USER_ID);
                roleSt.setLong(1, user.getId());
                ResultSet rsRole = roleSt.executeQuery();
                while (rsRole.next()) {
                    role = new Role(rsRole.getLong("id"),
                                    rsRole.getString("role"));
                }
                user.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return user;
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
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
