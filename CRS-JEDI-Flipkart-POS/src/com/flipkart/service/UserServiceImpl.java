package com.flipkart.service;

import com.flipkart.constant.Role;
import com.flipkart.dao.*;
import com.flipkart.exception.UserNotFoundException;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.constant.Role.STUDENT;

public class UserServiceImpl implements UserInterface{
    public UserServiceImpl() {

    }
    @Override
    public void getUserDetails() {

    }

    @Override
    public void updatePassword() {
        System.out.print("Enter userId: ");
        Scanner scanner = new Scanner(System.in);
        int userId = scanner.nextInt();
        scanner.nextLine();
        String newPassword = scanner.nextLine();
        UserDaoInterface user = new UserDaoImpl();
        user.updatePassword(userId, newPassword);
    }

    @Override
    public Role verifyCredentials(int username, String password) throws UserNotFoundException {

        UserDaoInterface user = new UserDaoImpl();
        boolean auth = user.verifyCredentials(username,password);
        Role role = null;
        if (auth) {
            role = Role.intToName(user.getRole(username));
//            System.out.println(username);
//            System.out.println(user.getRole(username));
//            System.out.println(role.toString());
            ProfessorDaoInterface professor = new ProfessorDaoImpl();
            System.out.println("Welcome "+professor.getProfessorById(username) + "!!!");
            if(role==STUDENT) {
                StudentDaoInterface student = new StudentServiceImpl();
                if(!student.isApproved(username)) {
                    return null;
                }
            }
        }
        return role;
    }
}
