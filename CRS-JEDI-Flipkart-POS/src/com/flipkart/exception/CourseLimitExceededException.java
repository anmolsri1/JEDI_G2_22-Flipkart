package com.flipkart.exception;

public class CourseLimitExceededException extends Exception {
    private int num;

    public CourseLimitExceededException(int num) {
        this.num = num;
    }

    public String getMessage() {
        return "You have already registered for " + this.num + " courses";
    }
}
