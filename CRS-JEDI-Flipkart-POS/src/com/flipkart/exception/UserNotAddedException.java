package com.flipkart.exception;

public class UserNotAddedException extends Exception {
    private int userId;

    public UserNotAddedException(int id) {
        this.userId = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getMessage() {
        return "UserId: " + this.userId + " not added!";
    }
}
