package com.flipkart.service;

import com.flipkart.app.CRSApplication;
import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.DummyData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentServiceImpl implements StudentInterface{
    DummyData data;
    public StudentServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void register() {
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
        data.approvalStudent.add(new Student("S105",name,password,address,1,gender,"S105",1));
        System.out.println("Your self-registration will be approved by admin. You will be notified shortly!!!");
        CRSApplication.showMenu(data);
    }

    @Override
    public void viewGrades() {
        System.out.println("Subject 1: A");
        System.out.println("Subject 2: A");
        System.out.println("Subject 3: A");
        System.out.println("Subject 4: A");
        System.out.println("Overall: A");
    }

    @Override
    public void addCourse() {
        List<Course> courses = viewCatalog();
        List<Course> selCourses = viewSelectedCourses();
        System.out.print("Select a course: ");
        Scanner scanner = new Scanner((System.in));
        String choice = scanner.nextLine();
        boolean courseFound = false;
//        System.out.println(courses);
        courses.forEach((course) -> {
            if(Objects.equals(choice,course.getCourseId())){
                selCourses.add(course);
                Catalog sel = new Catalog();
                sel.courseList = selCourses;
                data.selectedCourses.put("S101",sel);
                viewSelectedCourses();
                System.out.println("Course "+choice+" added successfully!");

            }
        });
//        System.out.println("Course not in catalog");
    }

    @Override
    public void dropCourse() {
        List<Course> selCourses = viewSelectedCourses();
        System.out.print("Choose a course to drop: ");
        Scanner scanner = new Scanner((System.in));
        String choice = scanner.nextLine();
        List<Course> updateSelCourses = new ArrayList<Course>();
        selCourses.forEach((selCourse) -> {
            if(!Objects.equals(selCourse.getCourseId(),choice)) {
                updateSelCourses.add(selCourse);
            }
        });
        Catalog sel = new Catalog();
        sel.courseList = updateSelCourses;
        data.selectedCourses.put("S101",sel);
        viewSelectedCourses();
        System.out.println("Course "+choice+" dropped successfully!");
    }

    @Override
    public List<Course> viewCatalog() {
        System.out.println("List of available courses: ");
        List<Course> courses = data.catalog.get(1).courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        return courses;
    }

    @Override
    public List<Course> viewSelectedCourses() {
        System.out.println("List of select courses: ");
        List<Course> courses = data.selectedCourses.get("S101").courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        Catalog cat = new Catalog();
        cat.setCourseList(courses);
        data.selectedCourses.put("S101",cat);
        return courses;
    }

    @Override
    public void payFee() {
        if(data.feePaid.contains("S101")) {
            System.out.println("You have already paid the fee.");
        }
        else {
            int numCourses = data.selectedCourses.get("S101").courseList.size();
            System.out.println("Fee due: "+numCourses*500);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select your preferred payment method: \n1. UPI \n2. Cash\n3. Netbanking");
            int choice = scanner.nextInt();
            if(choice==2){
                System.out.println("You may deposit your fee at the accounts department.");
            }
            else{
                System.out.println("Proceed to the payment gateway and do not clase this window. \n\n\nThank you fo making the payment");
                data.feePaid.add("S101");
            }
        }
    }
}
