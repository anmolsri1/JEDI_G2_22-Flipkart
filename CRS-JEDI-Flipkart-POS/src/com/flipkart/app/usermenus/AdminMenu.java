package com.flipkart.app.usermenus;

import com.flipkart.app.CRSApplication;
import com.flipkart.exception.*;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminServiceImpl;

import java.util.Scanner;

public class AdminMenu implements UserMenu {
    public AdminMenu(int userId) {
    }
    @Override
    public void showMenu() throws StudentNotFoundForApprovalException, UserIdAlreadyInUseException, ProfessorNotAddedException, CourseExistsAlreadyException, CourseNotDeletedException, CourseNotFoundException {
        System.out.println("----------Admin Menu----------");
        System.out.println("1. Verify Students");
        System.out.println("2. Add Professor");
        System.out.println("3. Get Grade Card");
        System.out.println("4. Add courses");
        System.out.println("5. Remove courses");
        System.out.println("6. Logout");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        AdminInterface admin = new AdminServiceImpl();
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                admin.verifyStudent();
                break;
            case 2:
                admin.addProfessor();
                break;
            case 3:
                admin.generateGradeCard();
                break;
            case 4:
                admin.addCourse();
                break;
            case 5:
                admin.removeCourse();
                break;
            case 6:
                CRSApplication.showMenu();
                break;
            default:
                System.out.println("Please select a valid option.");
        }
        showMenu();
    }
}
