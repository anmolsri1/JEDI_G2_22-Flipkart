package com.flipkart.exception;

public class UserIdAlreadyInUseException extends Exception {
    private int userId;

    public UserIdAlreadyInUseException(int id) {
        this.userId = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getMessage() {
        return "userId: " + this.userId + " is already in use.";
    }
}
