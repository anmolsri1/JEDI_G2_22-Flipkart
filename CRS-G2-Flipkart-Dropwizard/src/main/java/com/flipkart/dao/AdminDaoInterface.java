package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotAddedException;
import com.flipkart.exception.UserNotFoundException;
import java.util.List;

public interface AdminDaoInterface {
    List<Course> viewCourses();

    List<Professor> viewProfessors();

    /**
     * Method to generate grade card of a Student
     * var1
     * @return
     */
    void setGeneratedReportCardTrue(String var1);

    List<RegisteredCourse> generateGradeCard(int var1);

    List<Student> viewPendingAdmissions();

    /**
     * Method to approve a Student
     * studentId
     * @throws StudentNotFoundForApprovalException
     */
    void approveStudent(int studentID) throws StudentNotFoundForApprovalException;

    /**
     * Method to add Professor to DataBase
     * var1 : Professor Object storing details of a professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    void addProfessor(Professor var1) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to Delete Course from Course Catalog
     * @param var1
     * @throws CourseNotFoundException
     * @throws CourseNotDeletedException
     */
    void removeCourse(String var1) throws CourseNotFoundException, CourseNotDeletedException;

    /**
     * Method to add Course to Course Catalog
     * @param var1 : Course object storing details of a course
     * @throws CourseExistsAlreadyException;
     */
    void addCourse(Course var1) throws CourseExistsAlreadyException;

    /**
     * Method to add User
     * @param var1 : User object storing details of a user
     * @throws UserNotAddedException;
     * @throws UserIdAlreadyInUseException
     */
    void addUser(User var1) throws UserNotAddedException, UserIdAlreadyInUseException;

    List<Course> viewProfCourses();
}
