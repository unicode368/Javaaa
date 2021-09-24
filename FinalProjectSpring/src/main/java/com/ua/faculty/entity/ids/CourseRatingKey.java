package com.ua.faculty.entity.ids;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class CourseRatingKey implements Serializable {

    @Column(name = "course_id")
    Long courseId;

    @Column(name = "user_id")
    Long studentId;

}
