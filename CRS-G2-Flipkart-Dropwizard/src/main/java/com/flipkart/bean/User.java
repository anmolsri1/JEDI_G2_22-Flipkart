package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author Jedi-02
 * User abstract class
 */
public abstract class User {
    private int userId;
    private String name;
    private String password;
    private String address;
    private Role role;
    private Gender gender;

    public static String[] roleMap= {"", "STUDENT", "PROFESSOR", "ADMIN"};

    /**
     * Parameterised constructor to set user details
     * @param userId : user id
     * @param name : name
     * @param password : password
     * @param address : address
     * @param role : role
     * @param gender : gender
     */
    public User(int userId, String name, String password, String address, Role role, Gender gender) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.role = role;
        this.gender = gender;
    }

    /**
     * Default constructor
     */
    public User() {

    }

    /**
     * Mehtod to get user id
     * @return user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Method to set user id
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Method to get user name
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set user name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set password of user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to get address of user
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set address of user
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method to get role of user
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Method to set role of user
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Mehtod to get gender of user
     * @return gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Method to set gender of user
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
