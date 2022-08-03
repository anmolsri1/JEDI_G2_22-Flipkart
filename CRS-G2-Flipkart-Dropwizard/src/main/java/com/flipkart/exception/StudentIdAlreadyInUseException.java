package com.flipkart.exception;

public class StudentIdAlreadyInUseException extends Exception {
    private String studentId;

    /***
     * Setter function for ProfessorId
     * @param id
     */
    public StudentIdAlreadyInUseException(String id) {
        this.studentId = id;
    }

    /***
     * Getter function for ProfessorId
     */
    public String getUserId() {
        return this.studentId;
    }

    public String getMessage() {
        return "userId: " + this.studentId + " is already in use.";
    }
}
