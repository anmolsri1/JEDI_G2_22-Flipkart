package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

import java.util.List;

public interface StudentDaoInterface {
    /**
     * Method to add student to database
     * @param student: student object containing all the fields
     * @return true if student is added, else false
     * @throws StudentNotRegisteredException
     */
    public String addStudent(Student student) throws StudentNotRegisteredException;


    /**
     * Method to retrieve Student Id from User Id
     * @param userId
     * @return Student Id
     */
    public String getStudentId(int userId);

    /**
     * Method to check if Student is approved
     * @param studentId
     * @return boolean indicating if student is approved
     */
    public boolean isApproved(int studentId);

    void addCourse(int studentId, int courseId);

    void dropCourse(int studentId, int courseId);

    List<Course> viewSelectedCourses(int studentId);
}
