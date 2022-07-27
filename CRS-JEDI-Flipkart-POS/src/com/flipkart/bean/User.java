package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public abstract class User {
    private String userId;
    private String name;
    private String password;
    private String address;
    private Role role;
    private Gender gender;

    public User(String userId, String name, String password, String address, Role role, Gender gender) {
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

    public void getUserDetails() {
        this.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", gender=" + gender +
                '}';
    }
}
