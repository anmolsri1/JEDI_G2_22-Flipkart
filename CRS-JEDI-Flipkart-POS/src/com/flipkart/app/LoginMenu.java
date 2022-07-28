package com.flipkart.app;

import com.flipkart.app.usermenus.AdminMenu;
import com.flipkart.app.usermenus.ProfessorMenu;
import com.flipkart.app.usermenus.StudentMenu;
import com.flipkart.app.usermenus.UserMenu;
import com.flipkart.bean.User;
import com.flipkart.dao.DummyData;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserServiceImpl;

import java.util.Scanner;

public class LoginMenu {
    public static void showLoginMenu(DummyData data) {
        System.out.println("Login menu.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Roles: ");
        System.out.println("1. Student ");
        System.out.println("2. Professor ");
        System.out.println("3. Admin ");
        System.out.print("Select a role: ");
        int role = scanner.nextInt();

        // verifyCredentials
        UserInterface userInterface = new UserServiceImpl(data);
        if(!userInterface.verifyCredentials(username, password, User.roleMap[role])) {
            System.out.println("Wrong credentials...");
            return;
        }

        UserMenu userMenu = null;
        switch(role) {
            case 1:
                userMenu = new StudentMenu(data);
                userMenu.showMenu();
                break;
            case 2:
                userMenu = new ProfessorMenu(data);
                userMenu.showMenu();
                break;
            case 3:
                userMenu = new AdminMenu(data);
                userMenu.showMenu();
                break;

            default:
                System.out.println("Please select a valid option.");
        }

    }
}
