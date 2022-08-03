package com.flipkart.exception;

/**
 * Exception to check if the maximum number of registered courses is exceeded
 * @author Jedi-02
 *
 */
public class CourseLimitExceededException extends Exception {
    private int num;

    /**
     * Constructor
     * @param num number of courses
     */
    public CourseLimitExceededException(int num) {
        this.num = num;
    }

    /**
     * Message returned when exception is thrown
     */
    public String getMessage() {
        return "You have already registered for " + this.num + " courses";
    }
}
