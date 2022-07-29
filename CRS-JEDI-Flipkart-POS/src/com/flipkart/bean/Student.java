package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Student extends User{
    private String studentId;
    private int semester;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Student(String userId, String name, String password, String address, Role role, Gender gender, String studentId, int semester) {
        super(userId, name, password, address, role, gender);
        this.studentId = studentId;
        this.semester = semester;
    }

//    public void register() {
//        System.out.println("Registered a student with ID: " + studentId);
//    }
//
//    private void viewGrades() {
//        System.out.println("Viewing grades for the student with ID: " + studentId);
//    }
}
