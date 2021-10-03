package com.ua.faculty.repository;

import com.ua.faculty.entity.Course;
import com.ua.faculty.entity.CourseRating;
import com.ua.faculty.entity.User;
import com.ua.faculty.entity.ids.CourseRatingKey;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRatingRepository extends CrudRepository<CourseRating, Long> {
    Optional<CourseRating> findByUserAndCourse(User user, Course course);
    Optional<CourseRating> findById(CourseRatingKey courseRatingKey);
}
