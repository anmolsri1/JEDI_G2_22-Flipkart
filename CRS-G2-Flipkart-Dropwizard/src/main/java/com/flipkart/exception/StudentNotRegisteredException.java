package com.flipkart.exception;

/**
 * Exception to check if student is not registered
 *
 */
public class StudentNotRegisteredException extends Exception {
    private String studentName;

    /***
     * Setter function for UserId
     * @param studentName
     */
    public StudentNotRegisteredException(String studentName) {
        this.studentName = studentName;
    }

    /**
     * getter function for studentName
     * @return
     */
    public String getStudentName() {
        return this.studentName;
    }
}