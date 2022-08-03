package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author Jedi-02
 * Student bean class to set and get student details
 */
public class Student extends User{
    private String department;
    private int studentId;
    private int semester;
    private boolean isApproved;
    private boolean isReportGenerated;

    /**
     * Method to set student id
     * @return student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Method to get department
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Method to get approval status of student
     * @return approval status (yes/no)
     */
    public boolean getApproved() {
        return isApproved;
    }

    /**
     * Method to get status of report generated for student
     * @return isReportGenerated
     */
    public boolean getReportGenerated() {
        return isReportGenerated;
    }

    /**
     * Method to get student id
     * @param studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Method to get semester of student
     * @return semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Mehtod to set semester of student
     * @param semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Method to set department
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Method to set registration status of student
     * @param approved
     */
    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }

    /**
     * Method to set report generation status
     * @param isReportGenerated
     */
    public void setReportGenerated(boolean isReportGenerated) {
        this.isReportGenerated = isReportGenerated;
    }

    /**
     * Parameterized Constructor
     * @param userId : user id
     * @param name : name
     * @param password : password
     * @param address : address
     * @param role : role (admin/professor/student)
     * @param gender : gender
     * @param studentId : student id
     * @param semester : semester
     * @param department : department
     * @param isApproved : is registration approved or not
     * @param isReportGenerated : is report generated or not
     */
    public Student(int userId, String name, String password, String address, Role role, Gender gender, int studentId, int semester, String department, boolean isApproved, boolean isReportGenerated) {
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
