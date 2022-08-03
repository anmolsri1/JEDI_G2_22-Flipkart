package com.flipkart.exception;

public class UserIdAlreadyInUseException extends Exception {
    private int userId;

    /***
     * Setter function for UserId
     * @param id
     */
    public UserIdAlreadyInUseException(int id) {
        this.userId = id;
    }

    /***
     * Getter function for UserId
     * @return
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Message returned when user is already in use
     */
    public String getMessage() {
        return "userId: " + this.userId + " is already in use.";
    }
}
