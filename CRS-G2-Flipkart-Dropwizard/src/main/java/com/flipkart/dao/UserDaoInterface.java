package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author Goenka
 */
public interface UserDaoInterface {

    /**
     * Method to verify credentials of Users from DataBase
     * @param userId
     * @param password
     * @return Verify credentials operation status
     * @throws UserNotFoundException
     */
    public boolean verifyCredentials(int userId,String password) throws UserNotFoundException;

    /**
     * Method to get Role of User from DataBase
     * @param userId
     * @return Role
     */
    public int getRole(int userId);


    /**
     * Method to update password of user in DataBase
     * @param userID
     * @param newPassword
     * @return Update Password operation Status
     */
    public boolean updatePassword(int userID,String newPassword);
}