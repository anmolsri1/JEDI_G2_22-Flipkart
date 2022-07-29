package com.flipkart.exception;

public class CourseNotAvailableException extends Exception {
    private String courseCode;

    public CourseNotAvailableException(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getMessage() {
        return "Seats are not available in : " + this.courseCode;
    }
}
