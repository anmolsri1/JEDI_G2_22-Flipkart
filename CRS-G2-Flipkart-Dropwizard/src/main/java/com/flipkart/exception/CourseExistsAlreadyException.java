package com.flipkart.exception;

/**
 * Exception to check if course is already present in catalog
 * @author Jedi-02
 *
 */
public class CourseExistsAlreadyException extends Exception {
    private int courseCode;

    /***
     * Constructor
     * @param courseCode
     */
    public CourseExistsAlreadyException(int courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Getter method
     * @return course code
     */
    public int getCourseCode() {
        return this.courseCode;
    }

    /**
     * Message returned when exception is thrown
     */
    public String getMessage() {
        return "Course: " + this.courseCode + " already exists in catalog.";
    }
}
