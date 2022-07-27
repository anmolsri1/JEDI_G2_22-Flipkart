package com.flipkart.app;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String[] args) {
//        while(true){
            showMenu();
//        }
    }

    public static void showMenu() {
        System.out.println("--------Welcome to CRS Menu--------");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Update Password");
        System.out.println("4. Exit");
        System.out.print("Enter user input: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                LoginMenu.showLoginMenu();
                break;
            case 2:
                StudentRegistrationMenu.showStudentRegistrationMenu();
                break;
            case 3:
                UpdatePasswordMenu.showUpdatePasswordMenu();
                break;
            case 4:
                ExitMenu.showExitMenu();
                break;
            default:
                System.out.println("Please select a valid option.");
        }
    }

}