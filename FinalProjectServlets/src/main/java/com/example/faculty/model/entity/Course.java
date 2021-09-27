package com.example.faculty.model.entity;

import java.time.LocalDate;

public class Course {

    private Long id;

    private String name;

    private String theme;

    private String info;

    private LocalDate startDate;

    private LocalDate endDate;


    public Course(Long id, String name, String theme,
            String info, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.info = info;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public Course(String name, String theme,
                  String info, String startDate, String endDate) {
        this.name = name;
        this.theme = theme;
        this.info = info;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public String getName() {
        return name;
    }

    public String getTheme() {
        return theme;
    }

    public String getInfo() {
        return info;
    }

    public String getStartDate() {
        return startDate.toString();
    }

    public String getEndDate() {
        return endDate.toString();
    }

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate);
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate);
    }
}