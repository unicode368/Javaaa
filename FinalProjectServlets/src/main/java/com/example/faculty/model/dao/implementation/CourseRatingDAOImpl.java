package com.example.faculty.model.dao.implementation;

import com.example.faculty.model.dao.CourseRatingDAO;
import com.example.faculty.model.entity.Course;
import com.example.faculty.model.entity.CourseRating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRatingDAOImpl implements CourseRatingDAO {
    private final Connection connection;

    public CourseRatingDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(CourseRating entity) {

    }

    @Override
    public Optional<CourseRating> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<CourseRating> findAll() {
        return null;
    }

    @Override
    public void update(CourseRating entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<CourseRating> findAllByUserId(Long id) {
        List<CourseRating> rates = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement(FIND_BY_USER_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                rates.add(new CourseRating(rs.getLong("id"),
                        id,
                        rs.getInt("grade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return rates;
    }
}
