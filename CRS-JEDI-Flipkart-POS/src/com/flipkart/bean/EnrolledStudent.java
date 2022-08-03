package com.flipkart.bean;

/**
 * @author Jedi-02
 * Bean class for enrolled students
 */
public class EnrolledStudent {
    String courseCode;
    String courseName;
    String studentId;

    /**
     * Parameterized Constructor
     * @param courseCode : course code
     * @param courseName : course name
     * @param studentId : student id
     */
    public EnrolledStudent(String courseCode,String courseName,String studentId){
        this.courseCode=courseCode;
        this.courseName=courseName;
        this.studentId=studentId;
    }

    /**
     * Method to get course code
     * @return course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Method to set course code
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Method to get course name
     * @return course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Method to set course name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Method to get student id
     * @return student id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Function to set student id
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
