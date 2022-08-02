package com.flipkart.service;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.exception.StudentNotRegisteredException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentServiceImpl implements StudentInterface{
//    DummyData data;
    public StudentServiceImpl() {}
    @Override
    public void register() throws StudentNotRegisteredException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();

        StudentDaoInterface student = new StudentDaoImpl();
        student.addStudent(new Student(101,name,password, address, Role.stringToName("student"), Role.stringToName(gender), 101, 1, "dept", false, false));
        System.out.println("Your self-registration will be approved by admin. You will be notified shortly!!!");
//        CRSApplication.showMenu(data);
    }

    @Override
    public void viewGrades(int studentId) {
        // use regcourses table to get grades for courses for SID and use courses table to get course names
        System.out.println("Subject 1: A");
        System.out.println("Subject 2: A");
        System.out.println("Subject 3: A");
        System.out.println("Subject 4: A");
        System.out.println("Overall: A");
    }

    @Override
    public void addCourse(int studentId) {
        viewCatalog();
        viewSelectedCourses(studentId);
        System.out.print("Select a course: ");
        Scanner scanner = new Scanner((System.in));
        int courseId = scanner.nextInt();
        scanner.nextLine();
        StudentDaoInterface student = new StudentDaoImpl();
        student.addCourse(studentId,courseId);
    }

    @Override
    public void dropCourse(int studentId) {
        viewSelectedCourses(studentId);
        System.out.print("Choose a course to drop: ");
        Scanner scanner = new Scanner((System.in));
        int courseId = scanner.nextInt();
        StudentDaoInterface student = new StudentDaoImpl();
        student.dropCourse(studentId,courseId);
    }

    @Override
    public List<Course> viewCatalog() {
        System.out.println("List of available courses: ");
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Course> courses = admin.viewCourses();
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        return courses;
    }

    @Override
    public List<Course> viewSelectedCourses(int studentId) {
        System.out.println("List of select courses: ");
        StudentDaoInterface student = new StudentDaoImpl();
        List<Course> courses = student.viewSelectedCourses(studentId);
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        return courses;
    }

    @Override
    public void payFee(int studentId) {
//        if(data.feePaid.contains("S101")) {
//            System.out.println("You have already paid the fee.");
//        }
//        else {
//            int numCourses = data.selectedCourses.get("S101").courseList.size();
//            System.out.println("Fee due: "+numCourses*500);
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Select your preferred payment method: \n1. UPI \n2. Cash\n3. Netbanking");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            if(choice==2){
//                System.out.println("You may deposit your fee at the accounts department.");
//            }
//            else{
//                System.out.println("Proceed to the payment gateway and do not clase this window. \n\n\nThank you fo making the payment");
//                data.feePaid.add("S101");
//            }
//        }
    }
}