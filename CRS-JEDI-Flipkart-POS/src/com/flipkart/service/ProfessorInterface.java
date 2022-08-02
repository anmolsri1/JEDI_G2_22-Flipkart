package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {
    void viewEnrolledStudents(int profId);
    void addGrade();
    void registerForCourses(int profId);
}
