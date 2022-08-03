package com.flipkart.app;

import com.flipkart.exception.*;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentServiceImpl;

public class StudentRegistrationMenu {
    /**
     * Method to enable Students to register themselves, pending approval from admin
     */
    public static void showStudentRegistrationMenu() throws StudentNotRegisteredException, UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException {
        StudentInterface student = new StudentServiceImpl();
        student.register();
    }
}
