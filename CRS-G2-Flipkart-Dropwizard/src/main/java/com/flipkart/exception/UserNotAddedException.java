package com.flipkart.exception;

public class UserNotAddedException extends Exception {
    /**
     * Exception to check if user cannot be added
     *
     */
    private int userId;


    public UserNotAddedException(int id) {
        this.userId = id;
    }

    /**
     * getter function for UserId
     * @return
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Message returned when user is not added
     */
    public String getMessage() {
        return "UserId: " + this.userId + " not added!";
    }
}
