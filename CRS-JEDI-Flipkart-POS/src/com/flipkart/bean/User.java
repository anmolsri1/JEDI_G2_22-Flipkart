package com.flipkart.bean;

import com.flipkart.constant.Gender;

public abstract class User {
    private String userId;
    private String name;
    private String password;
    private String address;
    private int role;
    private Gender gender;

    public static String[] roleMap= {"", "STUDENT", "PROFESSOR", "ADMIN"};

    public User(String userId, String name, String password, String address, int role, String gender) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.role = role;
        this.gender = gender;
    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
