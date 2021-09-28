package com.example.faculty.model.dao.implementation;

import com.example.faculty.model.dao.CourseDAO;
import com.example.faculty.model.entity.Course;
import com.example.faculty.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements CourseDAO {

    private final Connection connection;

    public CourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Course entity) {

    }

    @Override
    public Optional<Course> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(FIND_ALL);
            while (rs.next()) {
                courses.add(new Course(rs.getLong("id"),
                                        rs.getString("course_name"),
                                        rs.getString("theme"),
                                        rs.getString("info"),
                                        rs.getString("start_date"),
                                        rs.getString("end_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return courses;
    }

    @Override
    public void update(Course entity) {

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
    public Course findById(Long id) {
        Course course = null;
        try (PreparedStatement statement = connection
                .prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                course = new Course(rs.getString("course_name"),
                        rs.getString("theme"),
                        rs.getString("info"),
                        rs.getString("start_date"),
                        rs.getString("end_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return course;
    }

    @Override
    public List<Course> findByTheme(String theme) {
        List<Course> courses = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement(FIND_BY_THEME)) {
            statement.setString(1, theme);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                courses.add(new Course(rs.getLong("id"),
                        rs.getString("course_name"),
                        rs.getString("theme"),
                        rs.getString("info"),
                        rs.getString("start_date"),
                        rs.getString("end_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return courses;
    }
}
