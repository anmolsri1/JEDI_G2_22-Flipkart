package com.flipkart.exception;

public class StudentNotFoundForApprovalException extends Exception {
    private String StudentId;

    public StudentNotFoundForApprovalException(String id) {
        this.StudentId = id;
    }

    public String getUserId() {
        return this.StudentId;
    }

    public String getMessage() {
        return "StudentId: " + this.StudentId + " not registered!";
    }
}
