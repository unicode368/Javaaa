package com.ua.faculty.exceptions;

public class StudentAlreadyEnrolledException extends Exception {
    public StudentAlreadyEnrolledException(String message) {
        super(message);
    }
}
