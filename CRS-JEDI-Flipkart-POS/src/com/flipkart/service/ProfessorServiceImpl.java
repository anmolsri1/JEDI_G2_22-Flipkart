package com.flipkart.service;

import com.flipkart.app.usermenus.ProfessorMenu;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author @author Jedi-02
 * Professor services implementation. Implements ProfessorInterface interface
 */
public class ProfessorServiceImpl implements ProfessorInterface{
    /**
     * Default constructor
     */
    public ProfessorServiceImpl() {

    }
    /**
     * Method to view students enrolled under the professor
     * @param professorId
     */
    @Override
    public void viewEnrolledStudents(int professorId) {
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        int courseId = professor.getCourseIdFromProfessorId(professorId);
        List<EnrolledStudent> studentList = professor.getEnrolledStudents(professorId);
        studentList.forEach((student) -> {
            System.out.println(student.getStudentId()+"\t"+student.getCourseCode()+"\t"+student.getCourseName());
        });
    }

    /**
     * Method to add grade for a student in a course
     */
    @Override
    public void addGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();

        System.out.println("Please enter Course ID: ");
        int courseId = sc.nextInt();
        sc.nextLine();

        System.out.println("Please enter Grade: ");
        String grade = sc.nextLine();

        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        professor.addGrade(studentId, courseId, grade);
    }

    /**
     * Method to help a professor register to a course
     * @param professorId
     */
    @Override
    public void registerForCourses(int professorId) {
        Scanner sc = new Scanner(System.in);
//        data.profCourses.put("P101", course_id); //Change This line
        AdminDaoInterface admin = new AdminDaoImpl();
        List<Course> courseList= admin.viewProfCourses();
        courseList.forEach((course) -> {
            System.out.println(course.getCourseId()+"\t"+course.getCourseName() + "\t" + course.getCourseType());
        });
        if (courseList.size() == 0) return;
        ProfessorDaoInterface professor = new ProfessorDaoImpl();
        System.out.println("Please enter Course ID: ");
        int courseId = sc.nextInt();
        sc.nextLine();
        professor.registerForCourses(professorId, courseId);
        System.out.println("Successfully registered for the course.");
    }
}
