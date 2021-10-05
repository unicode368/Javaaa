package com.ua.faculty.service;

import com.ua.faculty.entity.Course;
import com.ua.faculty.entity.CourseRating;
import com.ua.faculty.entity.ids.CourseRatingKey;
import com.ua.faculty.repository.CourseRatingRepository;
import com.ua.faculty.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseRatingService {

    public CourseRatingRepository courseRatingRepository;
    public CourseRepository courseRepository;

    public void enrollForCourse(CourseRating rating,
                                        Long courseId) {
        Course courseForEnroll = courseRepository.findById(courseId)
                .orElseThrow(() -> new UsernameNotFoundException(""));
        rating.setCourse(courseForEnroll);
        rating.getId().setCourseId(courseId);
        courseRatingRepository.save(rating);
    }


    public boolean checkIfUserIsEnrolled(Long userId, Long courseId) {
        try {
            CourseRating courseRating = courseRatingRepository
                    .findById(new CourseRatingKey(courseId, userId))
                    .orElseThrow(() -> new UsernameNotFoundException(""));
            return true;
        } catch (UsernameNotFoundException e) {
            return false;
        }
    }
}
