package com.flipkart.app.usermenus;

import com.flipkart.app.CRSApplication;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentServiceImpl;

import java.util.Scanner;

public class StudentMenu implements UserMenu {
    public StudentMenu() {
    }
    @Override
    public void showMenu() {
        System.out.println("----------Student Menu----------");
        System.out.println("1. Add Course");
        System.out.println("2. Drop Course");
        System.out.println("3. View Catalog");
        System.out.println("4. View Grade Card");
        System.out.println("5. View Selected Courses");
        System.out.println("6. Pay Fee");
        System.out.println("7. Log out");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        StudentInterface student = new StudentServiceImpl();
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                student.addCourse();
                break;
            case 2:
                student.dropCourse();
                break;
            case 3:
                student.viewCatalog();
                break;
            case 4:
                student.viewGrades();
                break;
            case 5:
                student.viewSelectedCourses();
                break;
            case 6:
                student.payFee();
                break;
            case 7:
                System.out.println("Successfully logged out!!!");
                CRSApplication.showMenu();
            default:
                System.out.println("Please select a valid option.");
        }
        showMenu();
    }
}
