package com.flipkart.exception;

/**
 * @author Jedi-02
 * Exception to check if grade is alloted or not
 */
public class GradeNotAllotedException extends Exception {
    private String studentId;

    /**
     * Constructor
     * @param studentId2
     */
    public GradeNotAllotedException(String studentId2) {
        this.studentId = studentId2;
    }

    /**
     * Getter function for studentId
     * @return
     */
    public String getStudentId() {
        return this.studentId;
    }

    /**
     * Message returned when exception is thrown
     */
    public String getMessage() {
        return "Student with id: " + this.studentId + "hasn't been alloted a grade yet";
    }
}
