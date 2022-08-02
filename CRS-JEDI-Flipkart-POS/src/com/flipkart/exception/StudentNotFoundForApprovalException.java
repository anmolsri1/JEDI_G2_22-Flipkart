package com.flipkart.exception;

public class StudentNotFoundForApprovalException extends Exception {
    private int studentId;

    public StudentNotFoundForApprovalException(int id) {
        this.studentId = id;
    }

    public int getUserId() {
        return this.studentId;
    }

    public String getMessage() {
        return "studentId: " + this.studentId + " not registered!";
    }
}
