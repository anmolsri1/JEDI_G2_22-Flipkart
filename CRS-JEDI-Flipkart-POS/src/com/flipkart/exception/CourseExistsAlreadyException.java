package com.flipkart.exception;

public class CourseExistsAlreadyException extends Exception {
    private int courseCode;

    public CourseExistsAlreadyException(int courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCode() {
        return this.courseCode;
    }

    public String getMessage() {
        return "Course: " + this.courseCode + " already exists in catalog.";
    }
}
