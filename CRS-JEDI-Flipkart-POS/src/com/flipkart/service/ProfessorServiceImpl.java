package com.flipkart.service;

import com.flipkart.app.usermenus.ProfessorMenu;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.*;
import java.util.List;
import java.util.Scanner;

public class ProfessorServiceImpl implements ProfessorInterface{
    DummyData data;
    public ProfessorServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void viewEnrolledStudents(int professorId) {
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        System.out.println("Enter you ID");
        Scanner scanner = new Scanner(System.in);
        int profId = scanner.nextInt();
        int courseId = professor.getCourseIdFromProfessorId(profId);
        List<EnrolledStudent> studentList = professor.getEnrolledStudents(courseId);
        studentList.forEach((student) -> {
            System.out.println(student.getStudentId()+"\t"+student.getCourseCode()+"\t"+student.getCourseName());
        });
    }

    @Override
    public void addGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Student ID: ");
        int studentId = sc.nextInt();

        System.out.println("Please enter Course ID: ");
        int courseId = sc.nextInt();
        System.out.println("Please enter Grade: ");
        String grade = sc.nextLine();
//        data.mapGrades.put(student_id, new Pair<String, String>(course_id, grade)); // change this to add/update grade in registered courses table using SID and CID.
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        professor.addGrade(studentId, courseId, grade);
    }

    @Override
    public void registerForCourses(int professorId) {
        Scanner sc = new Scanner(System.in);
//        data.profCourses.put("P101", course_id); //Change This line
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Course> courseList= admin.viewProfCourses();
        courseList.forEach((course) -> {
            System.out.println(course.getCourseId()+"\t"+course.getCourseName());
        });
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        System.out.println("Please enter Course ID: ");
        int courseId = sc.nextInt();
        professor.registerForCourses(professorId,courseId);
        System.out.println("Successfully registered for the course.");
    }
}
