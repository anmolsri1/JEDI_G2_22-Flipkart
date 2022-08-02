package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.*;

import java.util.List;

public interface StudentInterface {
    void register() throws StudentNotRegisteredException, UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException;
    void viewGrades(int studentId);
    void addCourse(int studentId);
    void dropCourse(int studentId);
    List<Course> viewCatalog();
    List<Course> viewSelectedCourses(int studentId);
    void payFee(int studentId);
}
