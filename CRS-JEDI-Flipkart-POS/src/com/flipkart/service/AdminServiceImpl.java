package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Jedi-02
 * Implementation of admin services. Implements AdminInterface interface
 */
public class AdminServiceImpl implements AdminInterface{

    /**
     * Default constructor
     */
    public AdminServiceImpl() {
    }

    /**
     * Method to see list of students who have pending approval and approve their registration
     * @throws StudentNotFoundForApprovalException
     */
    @Override
    public void verifyStudent() throws StudentNotFoundForApprovalException {
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Student> studentList = admin.viewPendingAdmissions();
        studentList.forEach(student -> {
            System.out.println(student.getStudentId()+"\t"+student.getName()+" "+student.getAddress()+" "+student.getGender()+" "+student.getSemester());
        });
        if (studentList.size() == 0) return;
        System.out.println("Enter a student ID to approve: ");
        Scanner scanner = new Scanner(System.in);
        int studentId = scanner.nextInt();
        scanner.nextLine();
        admin.approveStudent(studentId);
    }

    /**
     * Mehtod to add a new professor into the system
     * @throws UserIdAlreadyInUseException
     * @throws ProfessorNotAddedException
     */
    @Override
    public void addProfessor() throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();

        Professor professor = new Professor(id, name, password, address, 3, Gender.stringToGender(gender), id, department, position);
        AdminDaoInterface admin = new AdminDaoImpl();
        admin.addProfessor(professor);
    }

    /**
     * Mehtod to generate report card
     */
    @Override
    public void generateGradeCard() {
        AdminDaoInterface admin = new AdminDaoImpl();
        System.out.print("Enter student: ");
        Scanner scanner = new Scanner(System.in);
        int studentId = scanner.nextInt();
        scanner.nextLine();
        List<RegisteredCourse> courses = admin.generateGradeCard(studentId);
        courses.forEach((course) -> {
            if (course.getGrade().getGrade() == null) {
                System.out.println(course.getCourseId() + "\tNot Graded Yet! ");
            } else {
                System.out.println(course.getCourseId() + "\t" + course.getGrade().getGrade());
            }
        });
    }

    /**
     * Method to add course into course catalog
     * @throws CourseExistsAlreadyException
     */
    @Override
    public void addCourse() throws CourseExistsAlreadyException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter no. of seats: ");
        int seats = scanner.nextInt();
        scanner.nextLine();
        Course course = new Course(courseId,courseName,seats ,0);

        AdminDaoInterface admin = new AdminDaoImpl();
        admin.addCourse(course);
    }

    /**
     * Method to remove course from catalog
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     */
    @Override
    public void removeCourse() throws CourseNotDeletedException, CourseNotFoundException {
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Course> courses = admin.viewCourses();
        if(courses.size()==0){
            System.out.println("There are no courses to remove!!!");
            return;
        }
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        System.out.print("Choose a course to remove: ");
        Scanner scanner = new Scanner((System.in));
        String courseId = scanner.nextLine();
        admin.removeCourse(courseId);
    }
}
