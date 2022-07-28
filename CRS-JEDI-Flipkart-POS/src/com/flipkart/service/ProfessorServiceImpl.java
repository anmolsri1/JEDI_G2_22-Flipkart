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
    public List<Student> viewEnrolledStudents() {
        return null;
    }

    @Override
    public void addGrade() {

    }

    @Override
    public void registerForCourses() {

    }
}
