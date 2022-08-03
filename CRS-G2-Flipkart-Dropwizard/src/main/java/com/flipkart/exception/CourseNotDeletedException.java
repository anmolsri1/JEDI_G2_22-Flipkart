package com.flipkart.exception;

/**
 * @author Jedi-02
 * Exception to check for deleted course
 */
public class CourseNotDeletedException extends Exception {
    private String courseCode;

    public CourseNotDeletedException(String courseCode) {
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
     * Message thrown by exception
     */
    public String getMessage() {
        return "Course with courseCode: " + this.courseCode + " can't be deleted.";
    }
}
