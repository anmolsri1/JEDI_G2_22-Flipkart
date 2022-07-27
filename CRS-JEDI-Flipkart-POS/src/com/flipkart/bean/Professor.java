package com.flipkart.bean;

import com.flipkart.constant.Gender;

public class Professor extends User{
    private String professorId;
    private String department;
    private String position;

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Professor(String userId, String name, String password, String address, int role, Gender gender, String professorId, String department, String position) {
        super(userId, name, password, address, role, gender);
        this.professorId = professorId;
        this.department = department;
        this.position = position;
    }
}
