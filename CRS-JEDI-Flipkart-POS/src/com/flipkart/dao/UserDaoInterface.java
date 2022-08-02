package com.flipkart.dao;
import com.flipkart.constant.Role;
import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {
    public boolean verifyCredentials(int userId, String password, Role role) throws UserNotFoundException
}
