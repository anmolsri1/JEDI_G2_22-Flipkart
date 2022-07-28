package com.flipkart.service;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
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
        data.approvalStudent.forEach(student -> {
            System.out.println(student.getStudentId()+"\t"+student.getName()+" "+student.getAddress()+" "+student.getGender()+" "+student.getSemester());
        });
        System.out.println("Enter a student ID to approve: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        List<Student> updatedList= new ArrayList<Student>();
        data.approvalStudent.forEach(student -> {
            if(!Objects.equals(id,student.getStudentId())) {
                updatedList.add(student);
                return;
            }
            else data.registeredStudents.add(student);
        });
        data.approvalStudent = updatedList;
    }

    @Override
    public void addProfessor() {

    }

    @Override
    public GradeCard generateGradeCard() {
        return null;
    }

    @Override
    public void addCourse() {

    }

    @Override
    public void removeCourse() {
        List<Course> courses = data.catalog.get(1).courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        System.out.print("Choose a course to remove: ");
        Scanner scanner = new Scanner((System.in));
        String choice = scanner.nextLine();
        List<Course> updateCourses = new ArrayList<Course>();
        courses.forEach((course) -> {
            if(!Objects.equals(course.getCourseId(),choice)) {
                updateCourses.add(course);
            }
        });
        Catalog cat = new Catalog();
        cat.courseList = updateCourses;
        data.catalog.put(1,cat);
        courses = data.catalog.get(1).courseList;
        courses.forEach((course) -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
        System.out.println("Course "+choice+" removed successfully!");
    }
}
