package com.flipkart.exception;

public class UserNotFoundException extends Exception {
    private String userId;

    public UserNotFoundException(String id) {
        this.userId = id;
    }

    public String getMessage() {
        return "User with userId: " + this.userId + " not found.";
    }
}
