package com.flipkart.app.usermenus;

import java.util.Scanner;

public class ProfessorMenu implements UserMenu {

    @Override
    public void showMenu() {
        System.out.println("----------Professor Menu----------");
        System.out.println("1. Add Grades");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Register for courses");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                System.out.println("ADD GRADES OPTION SELECTED.");
                break;
            case 2:
                System.out.println("VIEW ENROLLED STUDENTS OPTION SELECTED.");
                break;
            case 3:
                System.out.println("REGISTER FOR COURSES OPTION SELECTED.");
                break;
            default:
                System.out.println("Please select a valid option.");
        }
    }
}
