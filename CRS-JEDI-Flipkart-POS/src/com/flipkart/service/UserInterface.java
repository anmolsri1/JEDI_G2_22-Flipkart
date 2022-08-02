package com.flipkart.service;


import com.flipkart.constant.Role;
import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
    void getUserDetails();
    void updatePassword();
    Role verifyCredentials(int name, String password) throws UserNotFoundException;
}
