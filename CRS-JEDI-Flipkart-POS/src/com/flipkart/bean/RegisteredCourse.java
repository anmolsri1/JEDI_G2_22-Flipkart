package com.flipkart.bean;

public class RegisteredCourse {
    private int courseId;
    private int studentId;
    private Grade grade;
    private int semester;

    public RegisteredCourse(int courseId, int studentId, Grade grade, int semester) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
        this.semester = semester;
    }

    public RegisteredCourse() {

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
