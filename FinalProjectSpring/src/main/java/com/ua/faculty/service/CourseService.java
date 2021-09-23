package com.ua.faculty.service;

import com.ua.faculty.entity.Course;
import com.ua.faculty.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserService userService;

    public List<Course> sort(List<Course> courses, String sortType) {
        switch (sortType) {
            case "nameASC":
                courses.sort(
                        Comparator.comparing(Course::getName,
                                Comparator.naturalOrder()));
                break;
            case "nameDESC":
                courses.sort(
                        Comparator.comparing(Course::getName,
                                Comparator.reverseOrder()));
                break;
            case "duration":
                courses.sort(
                        Comparator.comparing(o ->
                                getDuration(o.getId())));
                break;
            case "studentAmount":
                courses.sort(
                        Comparator.comparing(o ->
                                o.getStudents().size()));
                break;
        }
        return courses;
    }

    public Long getDuration(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(""));
        return DAYS.between(course.getEndDate(),
                course.getStartDate());
    }

    public List<Course> searchBy(String sortType,
                                        String userInput) {
        if (sortType.equals("theme")) {
            return courseRepository.findByTheme(userInput)
                    .orElseThrow(() -> new UsernameNotFoundException(""));
        } else {
            return courseRepository
                    .findByTeacher(userService.getTeacher(userInput))
                    .orElseThrow(() -> new UsernameNotFoundException(""));
        }
    }



}
