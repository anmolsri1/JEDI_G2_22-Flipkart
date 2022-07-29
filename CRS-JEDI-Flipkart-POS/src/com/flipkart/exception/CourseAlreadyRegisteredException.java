package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception {
    private String courseCode;

    public CourseAlreadyRegisteredException(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getMessage() {
        return "You have already registered for " + this.courseCode;
    }
}
