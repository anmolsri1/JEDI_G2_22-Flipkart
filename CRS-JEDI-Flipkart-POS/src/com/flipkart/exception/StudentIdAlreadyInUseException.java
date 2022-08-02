package com.flipkart.exception;

public class StudentIdAlreadyInUseException extends Exception {
    private String studentId;

    public StudentIdAlreadyInUseException(String id) {
        this.studentId = id;
    }

    public String getUserId() {
        return this.studentId;
    }

    public String getMessage() {
        return "userId: " + this.studentId + " is already in use.";
    }
}
