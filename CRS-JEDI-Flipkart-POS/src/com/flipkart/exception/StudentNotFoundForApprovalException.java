package com.flipkart.exception;

public class StudentNotFoundForApprovalException extends Exception {
    private String studentId;

    public StudentNotFoundForApprovalException(String id) {
        this.studentId = id;
    }

    public String getUserId() {
        return this.studentId;
    }

    public String getMessage() {
        return "studentId: " + this.studentId + " not registered!";
    }
}
