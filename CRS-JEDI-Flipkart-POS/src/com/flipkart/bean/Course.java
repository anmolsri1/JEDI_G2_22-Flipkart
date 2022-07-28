package com.flipkart.bean;

public class Course {
    private String courseId;
    private String courseName;
    private boolean isOffered;
    private String instructor;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isOffered() {
        return isOffered;
    }

    public void setOffered(boolean offered) {
        isOffered = offered;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Course(String courseId, String courseName, boolean isOffered, String instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isOffered = isOffered;
        this.instructor = instructor;
    }
}
