package com.flipkart.exception;

public class ProfessorIdAlreadyInUseException extends Exception {
    private String ProfessorId;

    public ProfessorIdAlreadyInUseException(String id) {
        this.ProfessorId = id;
    }

    /***
     * Getter function for ProfessorId
     */
    public String getUserId() {
        return this.ProfessorId;
    }

    public String getMessage() {
        return "userId: " + this.ProfessorId + " is already in use.";
    }
}
