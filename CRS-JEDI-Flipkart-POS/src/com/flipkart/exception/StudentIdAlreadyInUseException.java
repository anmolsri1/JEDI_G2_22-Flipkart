package com.flipkart.exception;

public class StudentIdAlreadyInUseException extends Exception {
    private String StudentId;

    public StudentIdAlreadyInUseException(String id) {
        this.StudentId = id;
    }

    public String getUserId() {
        return this.StudentId;
    }

    public String getMessage() {
        return "userId: " + this.StudentId + " is already in use.";
    }
}
