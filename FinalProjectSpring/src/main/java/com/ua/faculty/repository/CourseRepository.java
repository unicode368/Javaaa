package com.ua.faculty.repository;

import com.ua.faculty.entity.Course;
import com.ua.faculty.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<List<Course>> findByTheme(String theme);
    Optional<List<Course>> findByTeacher(User teacher);
}
