package com.flipkart.exception;

/**
 * Exception course is  not assigned to professor
 * @author Jedi-02
 *
 */
public class CourseNotAssignedException extends Exception {
    private String courseCode;
    private String userId;

    public CourseNotAssignedException(String courseCode, String userId) {
        this.courseCode = courseCode;
        this.userId = userId;
    }

    /**
     * Get courseCode
     * @return courseCode
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * get user id
     * @return user id
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * set user
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * set course code
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Message returned when exception is thrown
     */
    public String getMessage() {
        return "courseCode: " + this.courseCode + " couldn't be assigned to UserId: " + this.userId;
    }
}
