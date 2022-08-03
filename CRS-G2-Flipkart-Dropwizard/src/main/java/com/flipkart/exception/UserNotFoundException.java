package com.flipkart.exception;

/**
 * Exception to check if user exists
 *
 */
public class UserNotFoundException extends Exception {
    private int userId;

    /***
     * Setter function for UserId
     * @param id
     */
    public UserNotFoundException(int id) {
        this.userId = id;
    }

    /**
     * Message thrown by exception
     */
    public String getMessage() {
        return "User with userId: " + this.userId + " not found.";
    }
}
