package com.flipkart.app.usermenus;

import java.util.Scanner;

public class AdminMenu implements UserMenu {
    @Override
    public void showMenu() {
        System.out.println("----------Admin Menu----------");
        System.out.println("1. Verify Students");
        System.out.println("2. Add Professor");
        System.out.println("3. Generate Grade Card");
        System.out.println("4. Add or remove courses");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                System.out.println("VERIFY STUDENTS OPTION SELECTED.");
                break;
            case 2:
                System.out.println("ADD PROFESSOR OPTION SELECTED.");
                break;
            case 3:
                System.out.println("GENERATE GRADE CARD OPTION SELECTED.");
                break;
            case 4:
                System.out.println("ADD OR REMOVE COURSES OPTION SELECTED.");
                break;
            default:
                System.out.println("Please select a valid option.");
        }
    }
}
