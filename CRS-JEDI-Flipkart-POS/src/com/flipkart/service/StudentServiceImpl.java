package com.flipkart.service;

import com.flipkart.app.CRSApplication;
import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentServiceImpl implements StudentInterface{
//    DummyData data;
    public StudentServiceImpl() {}
    @Override
    public void register() throws StudentNotRegisteredException, UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();

        StudentDaoInterface student = new StudentDaoImpl();
        student.addStudent(new Student(id,name,password, address, Role.stringToName("student"), Gender.stringToGender(gender), id, semester, "CSE", false, false));
        System.out.println("Your self-registration will be approved by admin. You will be notified shortly!!!");
        CRSApplication.showMenu();
    }

    @Override
    public void viewGrades(int studentId) {
        // use regcourses table to get grades for courses for SID and use courses table to get course names
        StudentDaoInterface student = new StudentDaoImpl();
        List<RegisteredCourse> courses = student.viewGrades(studentId);
        courses.forEach((course) -> {
            System.out.println("Course ID"+"\t");
            if (course.getGrade().getGrade() == null) {
                System.out.println(course.getCourseId() + "\tNot Graded Yet! ");
            } else {
                System.out.println(course.getCourseId() + "\t" + course.getGrade().getGrade());
            }
        });
    }

    @Override
    public void addCourse(int studentId) {
        viewCatalog();
        List<Course> selectedCourses = viewSelectedCourses(studentId);
        if(selectedCourses.size()==6){
            System.out.println("You have already selected 6 courses!!!");
            return;
        }
        System.out.print("Select a course: ");
        Scanner scanner = new Scanner((System.in));
        int courseId = scanner.nextInt();
        scanner.nextLine();
        StudentDaoInterface student = new StudentDaoImpl();
        student.addCourse(studentId,courseId);
    }

    @Override
    public void dropCourse(int studentId) {
        List<Course> selectedCourses = viewSelectedCourses(studentId);
        if(selectedCourses.size()==0){
            System.out.println("You have no courses to drop!!!");
            return;
        }
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
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName() + " " + course.getCourseType()));
        return courses;
    }

    @Override
    public List<Course> viewSelectedCourses(int studentId) {
        System.out.println("List of select courses: ");
        StudentDaoInterface student = new StudentDaoImpl();
        List<Course> courses = student.viewSelectedCourses(studentId);
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName() + " " + course.getCourseType()));
        return courses;
    }

    @Override
    public void payFee(int studentId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your preferred payment method: \n1. UPI \n2. Cash\n3. Netbanking");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==2){
            System.out.println("You may deposit your fee at the accounts department.");
        }
        else{
            System.out.println("Proceed to the payment gateway and do not clase this window. \n\n\nThank you fo making the payment");
        }
    }
}