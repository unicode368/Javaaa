package com.ua.faculty.service;


import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private final CourseRepository courseRepository;

    public Integer getDuration(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

}
