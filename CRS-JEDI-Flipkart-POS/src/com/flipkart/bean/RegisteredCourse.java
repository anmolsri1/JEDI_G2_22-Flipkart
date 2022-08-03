package com.flipkart.bean;

/**
 * @author Jedi-02
 * Bean class for registered course
 */
public class RegisteredCourse {
    private int courseId;
    private int studentId;
    private Grade grade;
    private int semester;

    /**
     * Parameterized constructor
     * @param courseId
     * @param studentId
     * @param grade
     * @param semester
     */
    public RegisteredCourse(int courseId, int studentId, Grade grade, int semester) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
        this.semester = semester;
    }

    /**
     * Deafult constructor
     */
    public RegisteredCourse() {

    }

    /**
     * Method to get course id
     * @return course id
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Method to set course id
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Method to get student id
     * @return student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Method to set student id
     * @param studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Method to get grade
     * @return grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * Method to set grade
     * @param grade
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * Method to get semester
     * @return semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Method to set semester
     * @param semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }
}
