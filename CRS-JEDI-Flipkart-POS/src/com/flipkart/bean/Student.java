package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Student extends User{
    private String department;
    private String studentId;
    private int semester;
    private boolean isApproved;
    private boolean isReportGenerated;

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }
    public boolean getApproved() {
        return isApproved;
    }
    public boolean getReportGenerated() {
        return isReportGenerated;
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

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }
    public void setReportGenerated(boolean isReportGenerated) {
        this.isReportGenerated = isReportGenerated;
    }

    public Student(String userId, String name, String password, String address, Role role, Gender gender, String studentId, int semester, String department, boolean isApproved, boolean isReportGenerated) {
        super(userId, name, password, address, role, gender);
        this.studentId = studentId;
        this.semester = semester;
        this.department = department;
        this.isApproved = isApproved;
        this.isReportGenerated = isReportGenerated;
    }

//    public void register() {
//        System.out.println("Registered a student with ID: " + studentId);
//    }
//
//    private void viewGrades() {
//        System.out.println("Viewing grades for the student with ID: " + studentId);
//    }
}
