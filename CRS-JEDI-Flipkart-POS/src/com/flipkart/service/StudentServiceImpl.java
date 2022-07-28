package com.flipkart.service;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.dao.DummyData;

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
        viewSelectedCourses();
        System.out.print("Choose a course to drop: ");
        Scanner scanner = new Scanner((System.in));
        int choice = scanner.nextInt();
        System.out.println("Course "+String.valueOf(choice)+" dropped successfully!");
    }

    @Override
    public List<Course> viewCatalog() {
        System.out.println("List of available courses: ");
        List<Course> courses = data.catalog.get(1).courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
//        System.out.println(.getCourseId());
        return courses;
    }

    @Override
    public List<Course> viewSelectedCourses() {
        System.out.println("List of select courses: ");
        List<Course> courses = data.selectedCourses.get("S101").courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
//        System.out.println(.getCourseId());
//        System.out.println(data.selectedCourses.get("S101").courseList.get(0).getCourseName());
        Catalog cat = new Catalog();
        cat.setCourseList(courses);
        data.selectedCourses.put("S101",cat);
        return courses;
    }

    @Override
    public void payFee() {

    }
}
