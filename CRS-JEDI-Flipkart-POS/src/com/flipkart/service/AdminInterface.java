package com.flipkart.service;

import com.flipkart.bean.GradeCard;

public interface AdminInterface {
    void verifyStudent();
    void addProfessor();
    GradeCard generateGradeCard();
    void addCourse();
    void removeCourse();
}
