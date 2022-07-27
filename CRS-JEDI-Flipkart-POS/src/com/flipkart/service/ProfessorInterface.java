package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {
    List<Student> viewEnrolledStudents();
    void addGrade();
    void registerForCourses();
}
