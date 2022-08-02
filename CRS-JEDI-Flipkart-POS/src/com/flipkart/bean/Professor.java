package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Professor extends User{
    private int professorId;
    private String department;
    private String position;

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
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

    public Professor(){}
    public Professor(int userId, String name, String password, String address, int role, Gender gender, int professorId, String department, String position) {
        super(userId, name, password, address, Role.intToName(role), gender);
        this.professorId = professorId;
        this.department = department;
        this.position = position;
    }
}
