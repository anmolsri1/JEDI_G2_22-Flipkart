package com.flipkart.exception;

public class UserNotFoundException extends Exception {
    private int userId;

    public UserNotFoundException(int id) {
        this.userId = id;
    }

    public String getMessage() {
        return "User with userId: " + this.userId + " not found.";
    }
}
