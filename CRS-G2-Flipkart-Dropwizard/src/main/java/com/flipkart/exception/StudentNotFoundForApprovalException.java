package com.flipkart.exception;

public class StudentNotFoundForApprovalException extends Exception {
    private int studentId;

    public StudentNotFoundForApprovalException(int id) {
        this.studentId = id;
    }

    /**
     * Getter function for professorId
     * @return
     */
    public int getUserId() {
        return this.studentId;
    }

    /**
     * Message returned when user is already in use
     */
    public String getMessage() {
        return "studentId: " + this.studentId + " not registered!";
    }
}
