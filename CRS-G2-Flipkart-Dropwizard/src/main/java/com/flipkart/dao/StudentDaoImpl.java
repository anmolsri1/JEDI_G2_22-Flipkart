package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SqlQueriesConstant;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StudentDaoImpl implements StudentDaoInterface {
    private static volatile StudentDaoImpl instance=null;

    /**
     * Default Constructor
     */
    public StudentDaoImpl()
    {

    }

    /**
     * Method to make StudentDaoImpl Singleton
     * @return
     */
    public static StudentDaoImpl getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized(StudentDaoImpl.class){
                instance=new StudentDaoImpl();
            }
        }
        return instance;
    }

    /**
     * Method to add student to database
     * @param student: student object containing all the fields
     * @return true if student is added, else false
     * @throws StudentNotRegisteredException
     */
    @Override
    public String addStudent(Student student) throws StudentNotRegisteredException {
        Connection connection=DBUtils.getConnection();

        String studentId=null;
        try
        {
            //open db connection
            PreparedStatement preparedStatement=connection.prepareStatement(SqlQueriesConstant.ADD_USER_QUERY);
            preparedStatement.setInt(1, student.getUserId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setInt(4, 2);
            preparedStatement.setString(5, student.getGender().toString());
            preparedStatement.setString(6, student.getAddress());

            int rowsAffected=preparedStatement.executeUpdate();
            if(rowsAffected==1)
            {
                //add the student record
                //"insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
                PreparedStatement preparedStatementStudent;
                preparedStatementStudent=connection.prepareStatement(SqlQueriesConstant.ADD_STUDENT, Statement.RETURN_GENERATED_KEYS);
                preparedStatementStudent.setInt(1,student.getUserId());
                preparedStatementStudent.setString(2, student.getDepartment());
                preparedStatementStudent.setInt(3, student.getSemester());
                preparedStatementStudent.executeUpdate();
                ResultSet results=preparedStatementStudent.getGeneratedKeys();
                if(results.next())
                    studentId=results.getString(1);
            }


        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            throw new StudentNotRegisteredException(ex.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException err) {
                System.out.println("Error: " + err.getMessage());
                err.printStackTrace();
            }
        }
        return studentId;
    }

    /**
     * Method to retrieve Student Id from User Id
     * @param userId
     * @return StudentId
     */
    @Override
    public String getStudentId(int userId) {
        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_STUDENT_ID);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();

            if(rs.next())
            {
                return rs.getString("studentId");
            }

        }
        catch(SQLException err)
        {
            System.out.println("Error: " + err.getMessage());
        }

        return null;
    }

    /**
     * Method to check if Student is approved
     * @param studentId
     * @return boolean indicating if student is approved
     */
    @Override
    public boolean isApproved(int studentId) {
        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.IS_APPROVED);
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();

            if(rs.next())
            {
                return rs.getBoolean("isApproved");
            }

        }
        catch(SQLException err)
        {
            System.out.println("Error: " + err.getMessage());
        }

        return false;
    }

    /**
     * Method to add Course
     * @param studentId
     * @param courseId
     */
    @Override
    public void addCourse(int studentId, int courseId) {
        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.ADD_REGISTERED_COURSE);
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
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

    /**
     * Method to drop a course
     * @param studentId
     * @param courseId
     */
    @Override
    public void dropCourse(int studentId, int courseId) {
        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.DROP_REGISTERED_COURSE);
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
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
     * Method to view the selected courses
     * @param studentId
     */
    public List<Course> viewSelectedCourses(int studentId) {
        Connection connection=DBUtils.getConnection();
        List<Course> courses = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_COURSE_ID_FROM_STUDENT_ID);
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();

            List<Integer> clist = new ArrayList<>();
            while(rs.next())
            {
                int cid = rs.getInt("courseId");
                clist.add(cid);
            }

            for(int i = 0; i < clist.size(); i++ ) {
                statement = connection.prepareStatement(SqlQueriesConstant.GET_COURSES_BY_ID);
                statement.setInt(1, clist.get(i));
                rs = statement.executeQuery();
                while(rs.next()) {
                    Course course = new Course(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
                    courses.add(course);
                }
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

        return courses;
    }

    /**
     * Method to view the grades
     * @param studentId
     */
    @Override
    public List<RegisteredCourse> viewGrades(int studentId) {
        Connection connection=DBUtils.getConnection();
        List<RegisteredCourse> courses = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesConstant.GET_REGISTERED_COURSES_BY_ID);
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                RegisteredCourse course = new RegisteredCourse(rs.getInt(1), rs.getInt(2), new Grade(rs.getString(3)), rs.getInt(4));
                courses.add(course);
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

        return courses;
    }
}
