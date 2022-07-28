package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.dao.DummyData;

import java.util.List;

public class ProfessorServiceImpl implements ProfessorInterface{
    DummyData data;
    public ProfessorServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void viewEnrolledStudents() {
        DummyData dummy = new DummyData();
        List<Student> students = dummy.enrolledStudents.get("C101");
        students.forEach((student) -> System.out.println("ID: " + student.getStudentId() + "\tName: " + student.getName()));
    }

    @Override
    public void addGrade() {

    }

    @Override
    public void registerForCourses() {

    }
}
