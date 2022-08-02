package com.flipkart.service;

import com.flipkart.constant.Role;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.dao.UserDaoInterface;
import com.flipkart.exception.UserNotFoundException;

public class UserServiceImpl implements UserInterface{
    public UserServiceImpl() {

    }
    @Override
    public void getUserDetails() {

    }

    @Override
    public void updatePassword() {

    }

    @Override
    public Role verifyCredentials(int username, String password) throws UserNotFoundException {

        UserDaoInterface user = new UserDaoImpl();
        boolean auth = user.verifyCredentials(username,password);
        Role role = null;
        if (auth) {
            System.out.println("RRR");
            role = Role.stringToName(user.getRole(username));
        }
        return role;
    }
}
