package com.flipkart.app;

import com.flipkart.app.usermenus.AdminMenu;
import com.flipkart.app.usermenus.ProfessorMenu;
import com.flipkart.app.usermenus.StudentMenu;
import com.flipkart.app.usermenus.UserMenu;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.exception.*;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserServiceImpl;

import java.util.Date;
import java.util.Scanner;
import java.time.*;

public class LoginMenu {
    public static void showLoginMenu() throws UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException {
        System.out.println("Login menu.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        int username = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // verifyCredentials
        UserInterface userInterface = new UserServiceImpl();
        Role role = userInterface.verifyCredentials(username, password);
        if(role == null) {
            System.out.println("Wrong credentials...");
            return;
        }
        Date currentDate = new Date();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println("Logged in at: " + localDate + " " + localTime);
        UserMenu userMenu = null;
        switch(role) {
            case STUDENT:
                userMenu = new StudentMenu(username);
                userMenu.showMenu();
                break;
            case PROFESSOR:
                userMenu = new ProfessorMenu(username);
                userMenu.showMenu();
                break;
            case ADMIN:
                userMenu = new AdminMenu(username);
                userMenu.showMenu();
                break;

            default:
                System.out.println("Please select a valid option.");
        }

    }
}
