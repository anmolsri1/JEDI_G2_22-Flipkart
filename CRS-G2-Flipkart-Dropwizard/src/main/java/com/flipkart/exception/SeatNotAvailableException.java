package com.flipkart.exception;

/**
 * Exception to check if seats are available for course registration
 *
 */
public class SeatNotAvailableException extends Exception {
    private String courseCode;

    /**
     * Constructor
     * @param courseCode
     */
    public SeatNotAvailableException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Message returned when seats are not available
     */
    public String getMessage() {
        return "Seats are not available in : " + this.courseCode;
    }
}
