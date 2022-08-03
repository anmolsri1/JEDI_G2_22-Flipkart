package com.flipkart.bean;

public class Course {
    private int courseId;
    private String courseName;
    private int seats;
    private int instructor;
    private String courseType;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
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

    public Course(int courseId, String courseName, int seats, int instructor, String courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.seats = seats;
        this.instructor = instructor;
        this.courseType = courseType;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
}
