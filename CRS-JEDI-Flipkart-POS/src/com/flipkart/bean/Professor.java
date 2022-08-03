package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author Jedi-02
 * Professor bean class to get and set professor info
 */

public class Professor extends User{
    private int professorId;
    private String department;
    private String position;

    /**
     *Method to get professor id
     * @return professor id
     */
    public int getProfessorId() {
        return professorId;
    }

    /**
     * Method to set professor id
     * @param professorId
     */
    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    /**
     * Method to get professor department
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Method to set professor department
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Method to get position of professor
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Method to set position of professor
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Default constructor
     */
    public Professor(){}

    /**
     * Parameterized Constructor
     * @param userId
     * @param name
     * @param password
     * @param address
     * @param role
     * @param gender
     * @param professorId
     * @param department
     * @param position
     */
    public Professor(int userId, String name, String password, String address, int role, Gender gender, int professorId, String department, String position) {
        super(userId, name, password, address, Role.intToName(role), gender);
        this.professorId = professorId;
        this.department = department;
        this.position = position;
    }
}
