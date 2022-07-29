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

    void setGeneratedReportCardTrue(String var1);

    List<RegisteredCourse> generateGradeCard(String var1);

    List<Student> viewPendingAdmissions();

    void approveStudent(String var1) throws StudentNotFoundForApprovalException;

    void addProfessor(Professor var1) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    void removeCourse(String var1) throws CourseNotFoundException, CourseNotDeletedException;

    void addCourse(Course var1) throws CourseExistsAlreadyException;

    void assignCourse(String var1, String var2) throws CourseNotFoundException, UserNotFoundException;

    void addUser(User var1) throws UserNotAddedException, UserIdAlreadyInUseException;
}
