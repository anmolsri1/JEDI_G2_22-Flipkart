package com.flipkart.service;

import com.flipkart.app.usermenus.ProfessorMenu;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.*;
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
//        List<Student> students = data.enrolledStudents.get("C101");// join professor and regcourses on CID to get the list of students
//        students.forEach((student) -> System.out.println("ID: " + student.getStudentId() + "\tName: " + student.getName()));
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        System.out.println("Enter you ID");
        Scanner scanner = new Scanner(System.in);
        int profId = scanner.nextInt();
        int courseId = professor.getCourseIdFromProfessorId(profId);
        List<EnrolledStudent> studentList = professor.getEnrolledStudents(profId, courseId);
    }

    @Override
    public void addGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Student ID: ");
        int studentId = sc.nextInt();

        System.out.println("Please enter Course ID: ");
        int courseId = sc.nextInt();
        System.out.println("Please enter Grade: ");
        int grade = sc.nextInt();
//        data.mapGrades.put(student_id, new Pair<String, String>(course_id, grade)); // change this to add/update grade in registered courses table using SID and CID.
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        professor.addGrade(studentId, courseId, grade);

    }

    @Override
    public void registerForCourses() {
        Scanner sc = new Scanner(System.in);
//        data.profCourses.put("P101", course_id); //Change This line
        AdminDaoInterface admin = new AdminDaoImpl();
        admin.viewCourses();
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        System.out.println("Please enter Course ID: ");
        String courseId = sc.nextLine();
        professor.registerForCourses(professorId, courseId);
        System.out.println("Successfully registered for the course.");
    }
}
