package com.flipkart.exception;

public class CourseNotAssignedException extends Exception {
    private String courseCode;
    private String userId;

    public CourseNotAssignedException(String courseCode, String userId) {
        this.courseCode = courseCode;
        this.userId = userId;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getMessage() {
        return "courseCode: " + this.courseCode + " couldn't be assigned to UserId: " + this.userId;
    }
}
