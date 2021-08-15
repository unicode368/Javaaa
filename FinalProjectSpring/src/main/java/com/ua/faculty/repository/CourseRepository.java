package com.ua.faculty.repository;

import com.ua.faculty.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
