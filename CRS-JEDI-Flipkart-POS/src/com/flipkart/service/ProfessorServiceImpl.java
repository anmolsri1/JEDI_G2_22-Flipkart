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
        List<Student> students = data.enrolledStudents.get("C101");
        students.forEach((student) -> System.out.println("ID: " + student.getStudentId() + "\tName: " + student.getName()));
    }

    @Override
    public void addGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Student ID: ");
        String student_id = sc.nextLine();
        System.out.println("Please enter Course ID: ");
        String course_id = sc.nextLine();
        System.out.println("Please enter Grade: ");
        String grade = sc.nextLine();
        data.mapGrades.put(student_id, new Pair<String, String>(course_id, grade));
    }

    @Override
    public void registerForCourses() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Course ID: ");
        String course_id = sc.nextLine();
        data.profCourses.put("P101", course_id);
    }
}
