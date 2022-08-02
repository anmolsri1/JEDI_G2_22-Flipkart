package com.flipkart.app;

import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentServiceImpl;

public class StudentRegistrationMenu {
    public static void showStudentRegistrationMenu() {
        StudentInterface student = new StudentServiceImpl();
        student.register();
    }
}
