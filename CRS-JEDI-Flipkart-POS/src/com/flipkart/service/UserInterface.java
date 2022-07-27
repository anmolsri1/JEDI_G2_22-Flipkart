package com.flipkart.service;


public interface UserInterface {
    void getUserDetails();
    void updatePassword();
    boolean verifyCredentials(String name, String password, String role);
}
