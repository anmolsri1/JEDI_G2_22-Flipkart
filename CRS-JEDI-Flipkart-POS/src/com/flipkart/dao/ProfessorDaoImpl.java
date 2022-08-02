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
    public List<EnrolledStudent> getEnrolledStudents(int courseId) {
        Connection connection=DBUtils.getConnection();
        List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_ENROLLED_STUDENTS);
            statement.setInt(1, courseId);

            ResultSet results = statement.executeQuery();
            while(results.next())
            {
                //public EnrolledStudent(String courseCode, String courseName, int studentId)
                enrolledStudents.add(new EnrolledStudent(results.getString("courseCode"),results.getString("courseName"),results.getString("studentId")));
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
    public Boolean addGrade(int studentId, int courseCode, int grade) {
        Connection connection= DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.ADD_GRADE);

            statement.setInt(1, grade);
            statement.setInt(2, courseCode);
            statement.setInt(3, studentId);

            int row = statement.executeUpdate();

            if(row==1)
                return true;
            else
                return false;
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
        return false;
    }

    /**
     * Method to Get professor name by id
     * @param profId
     * @return Professor Id in string
     */
    @Override
    public String getProfessorById(String profId) {
        String prof_Name = null;
        Connection connection=DBUtils.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_PROF_NAME);

            statement.setString(1, profId);
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
