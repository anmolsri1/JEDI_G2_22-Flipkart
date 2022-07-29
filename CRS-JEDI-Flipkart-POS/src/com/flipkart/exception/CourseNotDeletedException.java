package com.flipkart.exception;

public class CourseNotDeletedException extends Exception {
    private String courseCode;

    public CourseNotDeletedException(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getMessage() {
        return "Course with courseCode: " + this.courseCode + " can't be deleted.";
    }
}
