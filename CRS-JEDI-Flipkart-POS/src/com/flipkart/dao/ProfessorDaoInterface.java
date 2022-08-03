package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorDaoInterface {
    /**
     * Method to view list of enrolled Students using SQL Commands
     * @param: courseId: course code of the professor
     * @return: return the enrolled students for the corresponding course id.
     */
    public List<EnrolledStudent> getEnrolledStudents(int courseId);

    /**
     * Method to Grade a student using SQL Commands
     * @param: profId: professor id
     * @param: courseCode: course code for the corresponding
     * @return: returns the status after adding the grade
     */
    public Boolean addGrade(int studentId,int courseId,String grade);

    /**
     * Method to Get professor name by id
     * @param profId
     * @return ProfessorId in int
     */
    public String getProfessorById(int profId);


    void registerForCourses(int profId, int courseId);

    int getCourseIdFromProfessorId(int profId);
}
