package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public abstract class User {
    private int userId;
    private String name;
    private String password;
    private String address;
    private Role role;
    private Gender gender;

    public static String[] roleMap= {"", "STUDENT", "PROFESSOR", "ADMIN"};

    public User(int userId, String name, String password, String address, Role role, Gender gender) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.role = role;
        this.gender = gender;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
