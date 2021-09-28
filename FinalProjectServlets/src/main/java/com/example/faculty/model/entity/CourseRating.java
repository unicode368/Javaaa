package com.example.faculty.model.entity;

public class CourseRating {

    Long course_id;

    Long user_id;

    Integer rating;

    public CourseRating(Long course_id,
                        Long user_id,
                        Integer rating) {
        this.course_id = course_id;
        this.user_id = user_id;
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }
}
