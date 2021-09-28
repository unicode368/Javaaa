package com.example.faculty.model.service;

import com.example.faculty.model.dao.CourseDAO;
import com.example.faculty.model.dao.CourseRatingDAO;
import com.example.faculty.model.dao.DAOFactory;
import com.example.faculty.model.entity.Course;
import com.example.faculty.model.entity.CourseRating;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class CourseService {
    private final DAOFactory daoFactory;

    public CourseService(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Course> getAllCourses() {
        try (CourseDAO courseDao = daoFactory.createCourseDao()) {
            return courseDao.findAll();
        }
    }

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
                try  {
                    courses.sort(
                            Comparator.comparing(o ->
                                    daoFactory.createUserDao()
                                            .findAllStudentsByCourseId(o.getId()).size()));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                break;
        }
        return courses;
    }

    public List<Course> searchBy(String searchType,
                                 String userInput) {
        try (CourseDAO courseDAO = daoFactory.createCourseDao()) {
            if (searchType.equals("theme")) {
                return courseDAO.findByTheme(userInput);
            } else {
               return courseDAO
                        .findByTeacherId(daoFactory.createUserInfoDao()
                                .findTeacherByFullName(userInput).getId());
            }
        }
    }

    public Long getDuration(Long id) {
        try (CourseDAO courseDao = daoFactory.createCourseDao()) {
            Course course = courseDao.findById(id);
            return DAYS.between(LocalDate.parse(course.getEndDate()),
                    LocalDate.parse(course.getStartDate()));
        }
    }

    public List<Course> getAllStudentCourses(Long id) {
        try (CourseDAO courseDao = daoFactory.createCourseDao()) {
            return courseDao.findByUserId(id);
        }
    }

    public List<CourseRating> getCourseRatingsByUserId(Long id) {
        try (CourseRatingDAO courseRatingDAO
                     = daoFactory.createCourseRatingDao()) {
            return courseRatingDAO.findAllByUserId(id);
        }
    }

}
