package com.flipkart.service;

import com.flipkart.bean.GradeCard;
import com.flipkart.dao.DummyData;

public class AdminServiceImpl implements AdminInterface{
    DummyData data;
    public AdminServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void verifyStudent() {

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

    }
}
