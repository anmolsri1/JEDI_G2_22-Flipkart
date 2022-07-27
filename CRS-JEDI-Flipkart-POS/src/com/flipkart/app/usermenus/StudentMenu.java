package com.flipkart.app.usermenus;

import java.util.Scanner;

public class StudentMenu implements UserMenu {

    @Override
    public void showMenu() {
        System.out.println("----------Student Menu----------");
        System.out.println("1. Add Course");
        System.out.println("2. Drop Course");
        System.out.println("3. View Catalog");
        System.out.println("4. View Grade Card");
        System.out.println("5. View Selected Courses");
        System.out.println("6. Pay Fee");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                System.out.println("ADD COURSE OPTION SELECTED.");
                break;
            case 2:
                System.out.println("DROP COURSE OPTION SELECTED.");
                break;
            case 3:
                System.out.println("VIEW CATALOG OPTION SELECTED.");
                break;
            case 4:
                System.out.println("VIEW GRADE CARD OPTION SELECTED.");
                break;
            case 5:
                System.out.println("View Selected Courses");
                break;
            case 6:
                System.out.println("PAY FEE OPTION SELECTED.");
                break;
            default:
                System.out.println("Please select a valid option.");
        }
    }
}
