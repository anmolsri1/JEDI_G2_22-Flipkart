package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.List;

/**
 * @author Jedi-02
 * Interface for Professor Services
 */
public interface ProfessorInterface {
    /**
     * Method to view students enrolled under the professor
     * @param profId
     */
    void viewEnrolledStudents(int profId);

    /**
     * Method to add grade for a student in a course
     */
    void addGrade();

    /**
     * Method to help a professor register to a course
     * @param profId
     */
    void registerForCourses(int profId);
}
