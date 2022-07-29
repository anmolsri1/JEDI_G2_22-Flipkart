package com.flipkart.exception;

public class ProfessorNotAddedException extends Exception {
    private String professorId;

    public ProfessorNotAddedException(String id) {
        this.professorId = id;
    }

    public String getUserId() {
        return this.professorId;
    }

    public String getMessage() {
        return "professorId: " + this.professorId + " not added!";
    }
}
