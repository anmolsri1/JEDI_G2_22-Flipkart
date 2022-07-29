package com.flipkart.exception;

public class UserIdAlreadyInUseException extends Exception {
    private String userId;

    public UserIdAlreadyInUseException(String id) {
        this.userId = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getMessage() {
        return "userId: " + this.userId + " is already in use.";
    }
}
