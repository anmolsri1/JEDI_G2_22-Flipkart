package com.flipkart.app;

import com.flipkart.dao.DummyData;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String[] args) {
        DummyData data = new DummyData();
//        while(true){
            showMenu(data);
//        }
    }

    public static void showMenu(DummyData data) {
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
                LoginMenu.showLoginMenu(data);
                break;
            case 2:
                StudentRegistrationMenu.showStudentRegistrationMenu(data);
                break;
            case 3:
                UpdatePasswordMenu.showUpdatePasswordMenu(data);
                break;
            case 4:
                ExitMenu.showExitMenu(data);
                break;
            default:
                System.out.println("Please select a valid option.");
        }
    }

}