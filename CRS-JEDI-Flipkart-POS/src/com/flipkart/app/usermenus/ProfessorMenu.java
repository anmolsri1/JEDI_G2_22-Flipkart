package com.flipkart.app.usermenus;

import com.flipkart.dao.DummyData;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorServiceImpl;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentServiceImpl;

import java.util.Scanner;

public class ProfessorMenu implements UserMenu {
    DummyData data;
    public ProfessorMenu(DummyData data) {
        this.data = data;
    }

    @Override
    public void showMenu() {
        System.out.println("----------Professor Menu----------");
        System.out.println("1. Add Grades");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Register for courses");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        ProfessorInterface professor = new ProfessorServiceImpl(data);
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                System.out.println("ADD GRADES OPTION SELECTED.");
                break;
            case 2:
//                System.out.println("VIEW ENROLLED STUDENTS OPTION SELECTED.");
                professor.viewEnrolledStudents();
                break;
            case 3:
                System.out.println("REGISTER FOR COURSES OPTION SELECTED.");
                break;
            default:
                System.out.println("Please select a valid option.");
        }
    }
}
