package com.flipkart.exception;

/**
 * @author Jedi-02
 * Exception to check if course is found or not
 */
public class CourseNotFoundException extends Exception {
    private String courseCode;

    public CourseNotFoundException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Getter function for course code
     * @return courseCode
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Message returned when exception is thrown
     */
    public String getMessage() {
        return "Course with courseCode: " + this.courseCode + " not found.";
    }
}
