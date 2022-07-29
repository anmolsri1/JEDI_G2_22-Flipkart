package com.flipkart.exception;

public class CourseNotFoundException extends Exception {
    private String courseCode;

    public CourseNotFoundException(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getMessage() {
        return "Course with courseCode: " + this.courseCode + " not found.";
    }
}
