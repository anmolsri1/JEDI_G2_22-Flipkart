package com.flipkart.exception;

public class UserNotAddedException extends Exception {
    private String userId;

    public UserNotAddedException(String id) {
        this.userId = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getMessage() {
        return "UserId: " + this.userId + " not added!";
    }
}
