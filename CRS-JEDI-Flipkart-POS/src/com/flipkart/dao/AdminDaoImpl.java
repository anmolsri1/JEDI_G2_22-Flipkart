package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotAddedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDaoInterface {
    private static volatile AdminDaoImpl instance = null;
    private PreparedStatement statement = null;
    Connection connection = DBUtils.getConnection();

    /**
     * Default Constructor
     */
    public AdminDaoImpl() {}

    /**
     * Method to make AdminDaoImpl Singleton
     * @return
     */
    public static AdminDaoImpl getInstance() {
        if (instance == null) {
            synchronized(AdminDaoImpl.class) {
                instance = new AdminDaoImpl();
            }
        }
        return instance;
    }

    /**
     * Remove Course using SQL commands
     * @param courseId
     * @throws CourseNotFoundException
     * @throws CourseNotDeletedException
     */
    public void removeCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException {
        this.statement = null;
        try {
            String sql = "delete from catalogue where courseId = ?";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1, courseId);
            int row = this.statement.executeUpdate();
            System.out.println(row + " entries deleted.");
            if (row == 0) {
                System.out.println("Error: " + courseId + " not in catalog!");
                throw new CourseNotFoundException(courseId);
            } else {
                System.out.println("Course with courseCode: " + courseId + " was deleted.");
            }
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
            throw new CourseNotDeletedException(courseId);
        }
    }

    /**
     * Add Course using SQL commands
     * @param course
     * @throws CourseExistsAlreadyException
     */
    public void addCourse(Course course) throws CourseExistsAlreadyException {
        this.statement = null;
        try {
            String sql = "insert into catalogue(courseId, courseName, seats, courseType) values (?, ?, ?, ?)";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setInt(1, course.getCourseId());
            this.statement.setString(2, course.getCourseName());
            this.statement.setInt(3, course.getSeats());
            this.statement.setString(4, course.getCourseType());
            int row = this.statement.executeUpdate();
            System.out.println(row + " course added");
            if (row == 0) {
                System.out.println("Error: " + "Course with courseCode: " + course.getCourseId() + "not added to catalog.");
                throw new CourseExistsAlreadyException(course.getCourseId());
            } else {
                System.out.println("Course with courseCode: " + course.getCourseId() + " is added to catalog.");
            }
        } catch (SQLException var4) {
            System.out.println("Error: " + var4.getMessage());
            throw new CourseExistsAlreadyException(course.getCourseId());
        }
    }

    /**
     * Fetch Students yet to approved using SQL commands
     * @return List of Students yet to approved
     */
    public List<Student> viewPendingAdmissions() {
        this.statement = null;
        List<Student> userList = new ArrayList();
        try {
            String sql = "select id, name, password, type, gender, address, studentId, semester, student.department, isApproved, isReportGenerated from student, user where isApproved = 0 and studentId = id";
            this.statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = this.statement.executeQuery();
            while(resultSet.next()) {
                Student user = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(6), Role.stringToName(resultSet.getString(4)), Gender.stringToGender(resultSet.getString(5)), resultSet.getInt(7), resultSet.getInt(8), resultSet.getString(9), resultSet.getBoolean(10), resultSet.getBoolean(11));
                userList.add(user);
            }
            System.out.println(userList.size() + " students have pending-approval.");
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
        }
        return userList;
    }

    /**
     * Approve Student using SQL commands
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */
    public void approveStudent(int studentId) throws StudentNotFoundForApprovalException {
        this.statement = null;

        try {
            String sql = "update student set isApproved = 1 where studentId = ?";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setInt(1, studentId);
            int row = this.statement.executeUpdate();
            System.out.println(row + " student approved.");
            if (row == 0) {
                throw new StudentNotFoundForApprovalException(studentId);
            }

            System.out.println("Student with studentId: " + studentId + " approved by admin.");
        } catch (SQLException var4) {
            System.out.println("Error: " + var4.getMessage());
        }

    }

    /**
     * Method to add user using SQL commands
     * @param user
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException {
        this.statement = null;

        try {
            String sql = "insert into user(id, name, password, type, gender, address) values (?, ?, ?, ?, ?, ?)";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setInt(1, user.getUserId());
            this.statement.setString(2, user.getName());
            this.statement.setString(3, user.getPassword());
            this.statement.setInt(4, Role.toInt(user.getRole()));
            this.statement.setString(5, user.getGender().toString());
            this.statement.setString(6, user.getAddress());
            int row = this.statement.executeUpdate();
            System.out.println(row + " user added.");
            if (row == 0) {
                System.out.println("Error: " + "User with userId: " + user.getUserId() + " not added.");
                throw new UserNotAddedException(user.getUserId());
            } else {
                System.out.println("User with userId: " + user.getUserId() + " added.");
            }
        } catch (SQLException var4) {
            System.out.println("Error: " + var4.getMessage());
            throw new UserIdAlreadyInUseException(user.getUserId());
        }
    }

    /**
     * Add professor using SQL commands
     * @param professor
     * @throws UserIdAlreadyInUseException
     * @throws ProfessorNotAddedException
     */
    public void addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        try {
            this.addUser(professor);
        } catch (UserNotAddedException var5) {
            System.out.println("Error: " + var5.getMessage());
            throw new ProfessorNotAddedException(professor.getUserId());
        } catch (UserIdAlreadyInUseException var6) {
            System.out.println("Error: " + var6.getMessage());
            throw var6;
        }

        this.statement = null;

        try {
            String sql = "insert into professor(professorId, department, position) values (?, ?, ?)";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setInt(1, professor.getUserId());
            this.statement.setString(2, professor.getDepartment());
            this.statement.setString(3, professor.getPosition());
            int row = this.statement.executeUpdate();
            System.out.println(row + " professor added.");
            if (row == 0) {
                System.out.println("Error: " + "Professor with professorId: " + professor.getUserId() + " not added.");
                throw new ProfessorNotAddedException(professor.getUserId());
            } else {
                System.out.println("Professor with professorId: " + professor.getUserId() + " added.");
            }
        } catch (SQLException var4) {
            System.out.println("Error: " + var4.getMessage());
            throw new UserIdAlreadyInUseException(professor.getUserId());
        }
    }

    /**
     * View courses in the catalog
     * @return List of courses in the catalog
     */
    public List<Course> viewCourses() {
        this.statement = null;
        List<Course> courseList = new ArrayList();

        try {
            String sql = "select courseId, courseName, professorId, seats, courseType from catalogue";
            this.statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = this.statement.executeQuery();

            while(resultSet.next()) {
                Course course = new Course(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getInt(3), resultSet.getString(5));
                courseList.add(course);
            }

            System.out.println("Number of courses in the Catalog are : " + courseList.size());
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
        }

        return courseList;
    }

    /**
     * View courses taken by professors in the University
     * @return List of the courses taken by professor in the University
     */
    public List<Course> viewProfCourses() {
        this.statement = null;
        List<Course> courseList = new ArrayList();

        try {
            String sql = "select courseId, courseName, seats, courseType from catalogue where professorId is NULL";
            this.statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = this.statement.executeQuery();

            while(resultSet.next()) {
                Course course = new Course(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), 0, resultSet.getString(4));
                courseList.add(course);
            }

            System.out.println("Number of courses in the Catalog are : " + courseList.size());
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
        }

        return courseList;
    }

    /**
     * View professor in the university
     * @return List of the professors in the University
     */
    public List<Professor> viewProfessors() {
        this.statement = null;
        List<Professor> professorList = new ArrayList();

        try {
            String sql = "select id, name, gender, department, type, position, address, professorId from professor natural join user where id = professorId";
            this.statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = this.statement.executeQuery();

            while(resultSet.next()) {
                Professor professor = new Professor(resultSet.getInt(1), resultSet.getString(2), "*********", resultSet.getString(7), resultSet.getInt(5), Gender.stringToGender(resultSet.getString(3)), resultSet.getInt(8), resultSet.getString(4), resultSet.getString(5));
                professorList.add(professor);
            }

            System.out.println(professorList.size() + " professors in the institute.");
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
        }

        return professorList;
    }

    public void setGeneratedReportCardTrue(String studentId) {
        String sql1 = "update student set isReportGenerated = 1 where studentId = ?";

        try {
            this.statement = this.connection.prepareStatement(sql1);
            this.statement.setString(1, studentId);
            int var3 = this.statement.executeUpdate();
        } catch (SQLException var4) {
            System.out.println("Error: " + var4.getMessage());
        }

    }

    public List<RegisteredCourse> generateGradeCard(int studentId) {
        List<RegisteredCourse> CoursesOfStudent = new ArrayList();

        try {
            String sql = "select catalogue.courseId, courseName, professorId, seats, studentId, grade, semester, courseType from catalogue inner join registeredCourse on catalogue.courseId = registeredCourse.courseId where registeredCourse.studentId = ?";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setInt(1, studentId);
            ResultSet resultSet = this.statement.executeQuery();

            while(resultSet.next()) {
                Course course = new Course(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getInt(3), resultSet.getString(8));
                RegisteredCourse temp = new RegisteredCourse();
                temp.setCourseId(course.getCourseId());
                temp.setStudentId(studentId);
                temp.setGrade(new Grade(resultSet.getString(6)));
                CoursesOfStudent.add(temp);
            }

            String sql1 = "update student set isReportGenerated = 1 where studentId = ?";
            this.statement = this.connection.prepareStatement(sql1);
            this.statement.setInt(1, studentId);
            int var9 = this.statement.executeUpdate();
            System.out.println("Graded");
        } catch (SQLException var7) {
            System.out.println("Error: " + var7.getMessage());
        }

        return CoursesOfStudent;
    }
}
