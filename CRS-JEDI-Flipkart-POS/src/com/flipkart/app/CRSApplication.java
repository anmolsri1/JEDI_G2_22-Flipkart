package com.flipkart.app;

import com.flipkart.exception.*;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String[] args) throws UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException {
//        while(true){
            showMenu();
//        }
    }

    public static void showMenu() throws UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException {
        System.out.println("--------Welcome to CRS Menu--------");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Update Password");
        System.out.println("4. Exit");
        System.out.print("Enter user input: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
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