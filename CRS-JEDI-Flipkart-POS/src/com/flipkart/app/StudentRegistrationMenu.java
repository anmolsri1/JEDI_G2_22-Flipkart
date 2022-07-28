package com.flipkart.app;

import com.flipkart.dao.DummyData;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentServiceImpl;

public class StudentRegistrationMenu {
    public static void showStudentRegistrationMenu(DummyData data) {
        StudentInterface student = new StudentServiceImpl(data);
        student.register();
    }
}
