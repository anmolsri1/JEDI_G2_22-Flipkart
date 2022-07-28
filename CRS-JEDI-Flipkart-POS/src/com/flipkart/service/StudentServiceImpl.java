package com.flipkart.service;

import com.flipkart.dao.DummyData;

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
//        DummyData dummy = new DummyData();
//        dummy.init();
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
//        DummyData dummy = new DummyData();
//        dummy.init();
        System.out.println("List of available courses: ");
        for(int i=1;i<=10;i++)
            System.out.println(String.valueOf(i)+". "+"Subject "+String.valueOf(i));
    }

    @Override
    public void viewSelectedCourses() {
        DummyData.init();
        System.out.println("List of select courses: ");
//        for(int i=1;i<=10;i++)
//            System.out.println(String.valueOf(i)+". "+"Subject "+String.valueOf(i));
        System.out.println(DummyData.selectedCourses.get("S101"));
    }

    @Override
    public void payFee() {

    }
}
