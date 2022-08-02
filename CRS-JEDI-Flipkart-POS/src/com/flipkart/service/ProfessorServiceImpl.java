package com.flipkart.service;

import com.flipkart.app.usermenus.ProfessorMenu;
import com.flipkart.bean.Student;
import com.flipkart.dao.DummyData;
import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

public class ProfessorServiceImpl implements ProfessorInterface{
    DummyData data;
    public ProfessorServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void viewEnrolledStudents() {
        List<Student> students = data.enrolledStudents.get("C101");// join professor and regcourses on CID to get the list of students
        students.forEach((student) -> System.out.println("ID: " + student.getStudentId() + "\tName: " + student.getName()));
    }

    @Override
    public void addGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Student ID: ");
        String studentId = sc.nextLine();
        System.out.println("Please enter Course ID: ");
        String course_id = sc.nextLine();
        System.out.println("Please enter Grade: ");
        String grade = sc.nextLine();
        data.mapGrades.put(studentId, new Pair<String, String>(course_id, grade)); // change this to add/update grade in registered courses table using SID and CID.
    }

    @Override
    public void registerForCourses() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Course ID: ");
        String course_id = sc.nextLine();
        data.profCourses.put("P101", course_id); //Change This line
        System.out.println("Successfully registered for the course.");
    }
}
