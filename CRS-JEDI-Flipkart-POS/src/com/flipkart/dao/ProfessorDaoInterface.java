package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorDaoInterface {
    /**
     * Method to view list of enrolled Students using SQL Commands
     * @param: profId: professor id
     * @param: courseCode: course code of the professor
     * @return: return the enrolled students for the corresponding professor and course code.
     */
    public List<EnrolledStudent> getEnrolledStudents(int courseId);

    /**
     * Method to GradeConstant a student using SQL Commands
     * @param: profId: professor id
     * @param: courseCode: course code for the corresponding
     * @return: returns the status after adding the grade
     */
    public Boolean addGrade(int studentId,int courseCode,int grade);

    /**
     * Method to Get professor name by id
     * @param profId
     * @return Professor Id in string
     */
    public String getProfessorById(String profId);


    void registerForCourses(int profId, int courseId);

    int getCourseIdFromProfessorId(int profId);
}
