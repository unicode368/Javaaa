package com.ua.faculty.exceptions;

public class TeacherDoesNotExistException extends Exception{
    public TeacherDoesNotExistException(String message) {
        super(message);
    }
}
