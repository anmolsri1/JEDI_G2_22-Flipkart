package com.flipkart.exception;

public class ProfessorNotAddedException extends Exception {
    private int professorId;

    public ProfessorNotAddedException(int id) {
        this.professorId = id;
    }

    public int getUserId() {
        return this.professorId;
    }

    /**
     * Message thrown by exception
     */
    public String getMessage() {
        return "professorId: " + this.professorId + " not added!";
    }
}
