package com.flipkart.service;


import com.flipkart.constant.Role;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author Jedi-02
 * Interface for User service
 */
public interface UserInterface {
    /**
     * Method to get details of user
     */
    void getUserDetails();

    /**
     * Method to update password of user
     */
    void updatePassword();

    /**
     * Method to verify credentials when a user wants to log in
     * @param name
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    Role verifyCredentials(int name, String password) throws UserNotFoundException;
}
