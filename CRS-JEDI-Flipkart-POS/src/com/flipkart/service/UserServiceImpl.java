package com.flipkart.service;

import com.flipkart.constant.Role;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.ProfessorDaoInterface;
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
            role = Role.intToName(user.getRole(username));
            System.out.println(username);
            System.out.println(user.getRole(username));
            System.out.println(role.toString());
            ProfessorDaoInterface professor = new ProfessorDaoImpl();
            System.out.println(professor.getProfessorById("Welcome "+username + "!!!"));
        }
        return role;
    }
}
