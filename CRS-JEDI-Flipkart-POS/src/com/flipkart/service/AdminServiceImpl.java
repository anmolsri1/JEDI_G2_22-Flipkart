package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.DummyData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdminServiceImpl implements AdminInterface{
    DummyData data;
    public AdminServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void verifyStudent() {
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Student> studentList = admin.viewPendingAdmissions();
        studentList.forEach(student -> {
            System.out.println(student.getStudentId()+"\t"+student.getName()+" "+student.getAddress()+" "+student.getGender()+" "+student.getSemester());
        });
        System.out.println("Enter a student ID to approve: ");
        Scanner scanner = new Scanner(System.in);
        int studentId = scanner.nextInt();
        admin.approveStudent(studentId);
    }

    @Override
    public void addProfessor() {
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

        Professor professor = new Professor(1, name, password, address, "professor", gender, 1, department, position);
        AdminDaoInterface admin = new AdminDaoImpl();
        admin.addProfessor(professor);
    }

    @Override
    public void generateGradeCard() {
        AdminDaoInterface admin = new AdminDaoImpl();
        System.out.print("Enter student: ");
        Scanner scanner = new Scanner(System.in);
        int studentId = scanner.nextInt();
        List<RegisteredCourse> courses = admin.generateGradeCard(studentId);
        courses.forEach((course) -> {
            System.out.println(course.getCourseId()+"\t"+course.getGrade());
        });
    }

    @Override
    public void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter instructor's name: ");
        String instructor = scanner.nextLine();
        Course course = new Course(courseId,courseName,true,instructor);

        AdminDaoInterface admin = new AdminDaoImpl();
        admin.addCourse(course);
    }

    @Override
    public void removeCourse() {
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Course> courses = admin.viewCourses();
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        System.out.print("Choose a course to remove: ");
        Scanner scanner = new Scanner((System.in));
        String courseId = scanner.nextLine();
        admin.removeCourse(courseId);

    }
}
