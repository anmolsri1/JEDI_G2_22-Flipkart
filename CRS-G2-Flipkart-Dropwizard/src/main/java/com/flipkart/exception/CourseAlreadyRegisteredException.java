package com.flipkart.exception;

/**
 * @author Jedi-02
 * Exception to check if course is already registered by student
 */
public class CourseAlreadyRegisteredException extends Exception {
    private String courseCode;

    /**
     * Constructor
     * @param courseCode
     */
    public CourseAlreadyRegisteredException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Getter method
     * @return course code
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Message returned when exception is thrown
     */
    public String getMessage() {
        return "You have already registered for " + this.courseCode;
    }
}
