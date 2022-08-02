package com.flipkart.app;

import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentServiceImpl;

public class StudentRegistrationMenu {
    public static void showStudentRegistrationMenu() throws StudentNotRegisteredException {
        StudentInterface student = new StudentServiceImpl();
        student.register();
    }
}
