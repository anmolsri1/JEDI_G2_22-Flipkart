package com.flipkart.bean;

/**
 * @author @author Jedi-02
 * Course bean class to get and store course details
 */
public class Course {
    private int courseId;
    private String courseName;
    private int seats;
    private int instructor;
    private String courseType;

    /**
     * Method to get course id
     * @return course id
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Method to set course id
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Method to set course name
     * @return Course Name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Method to set course name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Method to get number of seats offered in the course
     * @return Number of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     *
     * Mehtod to set number of seats
     * @param seats
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * Mehtod to get professor id for the given course
     * @return Professor id
     */
    public int getInstructor() {
        return instructor;
    }

    /**
     * Method to set professor id for the course
     * @param instructor
     */
    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }


    /**
     * Parameterized Constructor for Course bean class
     * @param courseId: Course Id
     * @param courseName: Course Name
     * @param seats: Number of seats offered
     * @param instructor: Professor Id
     */
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
