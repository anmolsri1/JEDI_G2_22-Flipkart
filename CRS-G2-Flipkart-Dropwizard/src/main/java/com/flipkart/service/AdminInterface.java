package com.flipkart.service;

import com.flipkart.bean.GradeCard;
import com.flipkart.exception.*;

/**
 * @author Jedi-02
 * Interface for Admin Services
 */

public interface AdminInterface {

    /**
     * Method to see list of students who have pending approval and approve their registration
     * @throws StudentNotFoundForApprovalException
     */
    void verifyStudent() throws StudentNotFoundForApprovalException;

    /**
     * Mehtod to add a new professor into the system
     * @throws UserIdAlreadyInUseException
     * @throws ProfessorNotAddedException
     */
    void addProfessor() throws UserIdAlreadyInUseException, ProfessorNotAddedException;

    /**
     * Mehtod to generate report card
     */
    void generateGradeCard();

    /**
     * Method to add course into course catalog
     * @throws CourseExistsAlreadyException
     */
    void addCourse() throws CourseExistsAlreadyException;

    /**
     * Method to remove course from catalog
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     */
    void removeCourse() throws CourseNotDeletedException, CourseNotFoundException;
}
