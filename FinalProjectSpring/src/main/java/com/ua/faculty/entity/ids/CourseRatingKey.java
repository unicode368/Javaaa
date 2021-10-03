package com.ua.faculty.entity.ids;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CourseRatingKey implements Serializable {

    @Column(name = "course_id")
    Long courseId;

    @Column(name = "user_id")
    Long studentId;

}
