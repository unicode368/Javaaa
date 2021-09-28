package com.example.faculty.model.entity;

import java.util.Collection;

public class Role {

    private Long id;

    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
