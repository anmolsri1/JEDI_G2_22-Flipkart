package com.flipkart.app.usermenus;

import com.flipkart.app.CRSApplication;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorServiceImpl;

import java.util.Scanner;

public class ProfessorMenu implements UserMenu {
    public ProfessorMenu(int professorId) {
    }

    @Override
    public void showMenu() {
        System.out.println("----------Professor Menu----------");
        System.out.println("1. Add Grades");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Register for courses");
        System.out.println("4. Logout");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        ProfessorInterface professor = new ProfessorServiceImpl();
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                professor.addGrade();
                break;
            case 2:
//                System.out.println("VIEW ENROLLED STUDENTS OPTION SELECTED.");
                professor.viewEnrolledStudents();
                break;
            case 3:
                professor.registerForCourses();
                break;
            case 4:
                CRSApplication.showMenu();
                break;
            default:
                System.out.println("Please select a valid option.");
        }

        showMenu();
    }
}
