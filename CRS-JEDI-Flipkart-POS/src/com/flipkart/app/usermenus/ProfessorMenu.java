package com.flipkart.app.usermenus;

import com.flipkart.app.CRSApplication;
import com.flipkart.exception.*;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorServiceImpl;

import java.util.Scanner;

public class ProfessorMenu implements UserMenu {
    private int professorId;
    public ProfessorMenu(int professorId) {
        this.professorId = professorId;
    }

    @Override
    public void showMenu() throws UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException, StudentNotRegisteredException {
        System.out.println("----------Professor Menu----------");
        System.out.println("1. Add Grades");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Register for courses");
        System.out.println("4. Logout");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        ProfessorInterface professor = new ProfessorServiceImpl();
        int option = scanner.nextInt();
        scanner.nextLine();
        switch(option) {
            case 1:
                professor.addGrade();
                break;
            case 2:
//                System.out.println("VIEW ENROLLED STUDENTS OPTION SELECTED.");
                professor.viewEnrolledStudents(professorId);
                break;
            case 3:
                professor.registerForCourses(professorId);
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
