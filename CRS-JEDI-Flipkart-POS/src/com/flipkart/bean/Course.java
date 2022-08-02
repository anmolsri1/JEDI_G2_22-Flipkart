package com.flipkart.bean;

public class Course {
    private String courseId;
    private String courseName;
    private int seats;
    private int instructor;

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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public Course(String courseId, String courseName, int seats, int instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.seats = seats;
        this.instructor = instructor;
    }
}
