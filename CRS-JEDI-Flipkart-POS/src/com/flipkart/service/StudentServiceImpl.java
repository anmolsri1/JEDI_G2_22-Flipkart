package com.flipkart.service;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.dao.DummyData;

import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentInterface{
    DummyData data;
    public StudentServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void register() {

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
        viewCatalog();
        System.out.print("Select a course: ");
        Scanner scanner = new Scanner((System.in));
        int choice = scanner.nextInt();
        System.out.println("Course "+String.valueOf(choice)+" added successfully!");

    }

    @Override
    public void dropCourse() {
        viewSelectedCourses();
        System.out.print("Choose a course to drop: ");
        Scanner scanner = new Scanner((System.in));
        int choice = scanner.nextInt();
        System.out.println("Course "+String.valueOf(choice)+" dropped successfully!");
    }

    @Override
    public void viewCatalog() {
        System.out.println("List of select courses: ");
        List<Course> courses = data.catalog.get(1).courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
//        System.out.println(.getCourseId());
    }

    @Override
    public void viewSelectedCourses() {
        System.out.println("List of select courses: ");
        List<Course> courses = data.selectedCourses.get("S101").courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
//        System.out.println(.getCourseId());
//        System.out.println(data.selectedCourses.get("S101").courseList.get(0).getCourseName());
        Catalog cat = new Catalog();
        cat.setCourseList(courses);
        data.selectedCourses.put("S101",cat);
    }

    @Override
    public void payFee() {

    }
}
