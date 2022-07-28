package com.flipkart.bean;

public class Course {
    private String courseId;
    private String courseName;
    private boolean isOffered;
    private String instructor;

    public Course(String courseId, String courseName, boolean isOffered, String instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isOffered = isOffered;
        this.instructor = instructor;
    }
}
