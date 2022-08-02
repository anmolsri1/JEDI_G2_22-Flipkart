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

public class AdminServiceImpl implements AdminInterface{
    public AdminServiceImpl() {
    }
    @Override
    public void verifyStudent() throws StudentNotFoundForApprovalException {
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Student> studentList = admin.viewPendingAdmissions();
        studentList.forEach(student -> {
            System.out.println(student.getStudentId()+"\t"+student.getName()+" "+student.getAddress()+" "+student.getGender()+" "+student.getSemester());
        });
        System.out.println("Enter a student ID to approve: ");
        Scanner scanner = new Scanner(System.in);
        int studentId = scanner.nextInt();
        scanner.nextLine();
        admin.approveStudent(studentId);
    }

    @Override
    public void addProfessor() throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
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

        Professor professor = new Professor(1, name, password, address, Role.stringToName("professor"), Gender.stringToGender(gender), 1, department, position);
        AdminDaoInterface admin = new AdminDaoImpl();
        admin.addProfessor(professor);
    }

    @Override
    public void generateGradeCard() {
        AdminDaoInterface admin = new AdminDaoImpl();
        System.out.print("Enter student: ");
        Scanner scanner = new Scanner(System.in);
        int studentId = scanner.nextInt();
        scanner.nextLine();
        List<RegisteredCourse> courses = admin.generateGradeCard(studentId);
        courses.forEach((course) -> {
            System.out.println(course.getCourseId()+"\t"+course.getGrade());
        });
    }

    @Override
    public void addCourse() throws CourseExistsAlreadyException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter instructor's name: ");
        int instructor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter no. of seats: ");
        int seats = scanner.nextInt();
        scanner.nextLine();
        Course course = new Course(courseId,courseName,seats ,instructor);

        AdminDaoInterface admin = new AdminDaoImpl();
        admin.addCourse(course);
    }

    @Override
    public void removeCourse() throws CourseNotDeletedException, CourseNotFoundException {
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Course> courses = admin.viewCourses();
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        System.out.print("Choose a course to remove: ");
        Scanner scanner = new Scanner((System.in));
        String courseId = scanner.nextLine();
        admin.removeCourse(courseId);
    }
}
