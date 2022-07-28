package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public interface StudentInterface {
    void register();
    void viewGrades();
    void addCourse();
    void dropCourse();
    List<Course> viewCatalog();
    List<Course> viewSelectedCourses();
    void payFee();
}
