package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.*;

import java.util.List;

/**
 * @author Jedi-02
 * Interface for Student Servies
 */
public interface StudentInterface {
    /**
     * Method to register a student. Student asks for approval and only then can register to courses
     * @throws StudentNotRegisteredException
     * @throws UserNotFoundException
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     * @throws CourseExistsAlreadyException
     * @throws UserIdAlreadyInUseException
     * @throws StudentNotFoundForApprovalException
     * @throws ProfessorNotAddedException
     */
    void register() throws StudentNotRegisteredException, UserNotFoundException, CourseNotDeletedException, CourseNotFoundException, CourseExistsAlreadyException, UserIdAlreadyInUseException, StudentNotFoundForApprovalException, ProfessorNotAddedException;

    /**
     * Mehtod to view grades of courses the student has registered
     * @param studentId
     */
    void viewGrades(int studentId);

    /**
     * Method to add course for registration
     * @param studentId
     */
    void addCourse(int studentId);

    /**
     * Method to drop course for registration
     * @param studentId
     */
    void dropCourse(int studentId);

    /**
     * Method to view course catalog
     * @return
     */
    List<Course> viewCatalog();

    /**
     * Method to view list of courses the student has registerd
     * @param studentId
     * @return
     */
    List<Course> viewSelectedCourses(int studentId);

    /**
     * Method to pay fee for the registration to complete
     * @param studentId
     */
    void payFee(int studentId);
}
