package com.example.faculty.model.exceptions;

public class TeacherDoesNotExistException extends Exception{
    public TeacherDoesNotExistException(String message) {
        super(message);
    }
}
