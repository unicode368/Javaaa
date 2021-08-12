package com.ua.faculty.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

}