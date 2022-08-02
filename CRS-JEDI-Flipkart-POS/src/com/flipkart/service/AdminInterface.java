package com.flipkart.service;

import com.flipkart.bean.GradeCard;
import com.flipkart.exception.*;

public interface AdminInterface {
    void verifyStudent() throws StudentNotFoundForApprovalException;
    void addProfessor() throws UserIdAlreadyInUseException, ProfessorNotAddedException;
    void generateGradeCard();
    void addCourse() throws CourseExistsAlreadyException;
    void removeCourse() throws CourseNotDeletedException, CourseNotFoundException;
}
