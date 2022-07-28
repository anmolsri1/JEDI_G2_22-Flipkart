package com.flipkart.service;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.dao.DummyData;

import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentInterface{
    @Override
    public void register() {

    }

    @Override
    public void viewGrades() {
//        DummyData dummy = new DummyData();
//        dummy.init();
        System.out.println("Subject 1: A");
        System.out.println("Subject 2: A");
        System.out.println("Subject 3: A");
        System.out.println("Subject 4: A");
        System.out.println("Overall: A");
    }

    @Override
    public void addCourse() {
        viewCatalog();
        System.out.print("Select a course: ");
        Scanner scanner = new Scanner((System.in));
        int choice = scanner.nextInt();
        System.out.println("Course "+String.valueOf(choice)+" added successfully!");

    }

    @Override
    public void dropCourse() {
//        DummyData dummy = new DummyData();
//        dummy.init();
        viewSelectedCourses();
        System.out.print("Choose a course to drop: ");
        Scanner scanner = new Scanner((System.in));
        int choice = scanner.nextInt();
        System.out.println("Course "+String.valueOf(choice)+" dropped successfully!");
    }

    @Override
    public void viewCatalog() {
        DummyData dummy = new DummyData();
        System.out.println("List of select courses: ");
        List<Course> courses = dummy.catalog.get(1).courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
//        System.out.println(.getCourseId());
    }

    @Override
    public void viewSelectedCourses() {
        DummyData dummy = new DummyData();
        System.out.println("List of select courses: ");
        List<Course> courses = dummy.selectedCourses.get("S101").courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
//        System.out.println(.getCourseId());
//        System.out.println(dummy.selectedCourses.get("S101").courseList.get(0).getCourseName());
        Catalog cat = new Catalog();
        cat.setCourseList(courses);
        dummy.selectedCourses.put("S101",cat);
    }

    @Override
    public void payFee() {

    }
}
