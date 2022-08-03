package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;
import com.flipkart.constant.SqlQueriesConstant;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoImpl implements ProfessorDaoInterface {
    @Override
    /**
     * Method to get the enrolled students
     * @param professorId
     * @return list of enrolled students
     */
    public List<EnrolledStudent> getEnrolledStudents(int professorId) {
        Connection connection=DBUtils.getConnection();
        List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_ENROLLED_STUDENTS);
            statement.setInt(1, professorId);

            ResultSet results = statement.executeQuery();
            while(results.next())
            {
                //public EnrolledStudent(String courseCode, String courseName, int studentId)
                enrolledStudents.add(new EnrolledStudent(results.getString("courseId"),results.getString("courseName"),results.getString("studentId")));
            }
        }
        catch(SQLException err)
        {
            System.out.println("Error: " + err.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return enrolledStudents;
    }

    @Override
    /**
     * Boolean method to add grade
     * @param studentId
     * @param courseId
     */
    public Boolean addGrade(int studentId, int courseId, String grade) {
        Connection connection= DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.ADD_GRADE);

            statement.setString(1, grade);
            statement.setInt(2, courseId);
            statement.setInt(3, studentId);

            int row = statement.executeUpdate();

            if(row==1)
                return true;
            else
                return false;
        }
        catch(SQLException err)
        {
            err.printStackTrace();
            System.out.println("Error: " + err.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Method to Get professor name by id
     * @param profId
     * @return Professor Id
     */
    @Override
    public String getProfessorById(int profId) {
        String prof_Name = null;
        Connection connection=DBUtils.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_PROF_NAME);

            statement.setInt(1, profId);
            ResultSet rs = statement.executeQuery();
            rs.next();

            prof_Name = rs.getString(1);

        }
        catch(SQLException err)
        {
            System.out.println("Error: " + err.getMessage());
        }
        finally
        {
            try
            {
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return prof_Name;
    }

    @Override
    /**
     * Method to register for courses
     * @param profId
     * @param courseId
     * @return list of enrolled students
     */
    public void registerForCourses(int profId, int courseId) {
        Connection connection= DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.REGISTER_FOR_COURSE);

            statement.setInt(1, profId);
            statement.setInt(2, courseId);

            int row = statement.executeUpdate();
        }
        catch(SQLException err)
        {
            System.out.println("Error: " + err.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    /**
     * Method to get CourseId from ProfessorId
     * @param profId
     */
    public int getCourseIdFromProfessorId(int profId) {
        int courseId = -1;
        Connection connection=DBUtils.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_COURSE_ID_FROM_PROF_ID);

            statement.setInt(1, profId);
            ResultSet rs = statement.executeQuery();
            rs.next();

            courseId = rs.getInt(1);
        }
        catch(SQLException err)
        {
            System.out.println("Error: " + err.getMessage());
        }
        finally
        {
            try
            {
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return courseId;
    }

    /**
     * Default Constructor
     */
    public ProfessorDaoImpl() {

    }
}
