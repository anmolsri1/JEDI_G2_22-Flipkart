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

    private AdminDaoImpl() {}

    public static AdminDaoImpl getInstance() {
        if (instance == null) {
            synchronized(AdminDaoImpl.class) {
                instance = new AdminDaoImpl();
            }
        }
        return instance;
    }

    public void removeCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException {
        this.statement = null;
        try {
            String sql = "delete from catalogue where course_id = ?";
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

    public void addCourse(Course course) throws CourseExistsAlreadyException {
        this.statement = null;
        try {
            String sql = "insert into catalogue(course_id, course_name, seats, professor_id) values (?, ?, ?, ?)";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1, course.getCourseId());
            this.statement.setString(2, course.getCourseName());
            this.statement.setInt(3, 10);
            this.statement.setString(4, "NOT_ASSIGNED");
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

    public List<Student> viewPendingAdmissions() {
        this.statement = null;
        List<Student> userList = new ArrayList();
        try {
            String sql = "select user, name, password, role, gender, address, StudentId from student, user where isApproved = 0 and StudentId = userId";
            this.statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = this.statement.executeQuery();
            while(resultSet.next()) {
                Student user = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(6), Role.stringToName(resultSet.getString(4)), Gender.stringToGender(resultSet.getString(5)), resultSet.getString(7), resultSet.getInt(8));
                userList.add(user);
            }
            System.out.println(userList.size() + " students have pending-approval.");
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
        }
        return userList;
    }

    public void approveStudent(String StudentId) throws StudentNotFoundForApprovalException {
        this.statement = null;

        try {
            String sql = "update Student set isApproved = 1 where StudentId = ?";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1, StudentId);
            int row = this.statement.executeUpdate();
            System.out.println(row + " student approved.");
            if (row == 0) {
                throw new StudentNotFoundForApprovalException(StudentId);
            }

            System.out.println("Student with StudentId: " + StudentId + " approved by admin.");
        } catch (SQLException var4) {
            System.out.println("Error: " + var4.getMessage());
        }

    }

    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException {
        this.statement = null;

        try {
            String sql = "insert into User(userId, name, password, role, gender, address) values (?, ?, ?, ?, ?, ?)";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1, user.getUserId());
            this.statement.setString(2, user.getName());
            this.statement.setString(3, user.getPassword());
            this.statement.setString(4, user.getRole().toString());
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
            String sql = "insert into Professor(professorId, department, designation) values (?, ?, ?)";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1, professor.getUserId());
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

    public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException {
        this.statement = null;

        try {
            String sql = "update Course set professorId = ? where courseCode = ?";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1, professorId);
            this.statement.setString(2, courseCode);
            int row = this.statement.executeUpdate();
            System.out.println(row + " course assigned.");
            if (row == 0) {
                System.out.println("Error: " + courseCode + " not found");
                throw new CourseNotFoundException(courseCode);
            } else {
                System.out.println("Course with courseCode: " + courseCode + " is assigned to professor with professorId: " + professorId + ".");
            }
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
            throw new UserNotFoundException(professorId);
        }
    }

    public List<Course> viewCourses() {
        this.statement = null;
        List<Course> courseList = new ArrayList();

        try {
            String sql = "select id, courseName, professorId from Course";
            this.statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = this.statement.executeQuery();

            while(resultSet.next()) {
                Course course = new Course(resultSet.getString(1), resultSet.getString(2), );
                course.setCourseName(resultSet.getString(2));
                course.setInstructor(resultSet.getString(3));
                courseList.add(course);
            }

            System.out.println("Number of courses in the Catalog are : " + courseList.size());
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
        }

        return courseList;
    }

    public List<Professor> viewProfessors() {
        this.statement = null;
        List<Professor> professorList = new ArrayList();

        try {
            String sql = "select userId, name, gender, department, designation, address from Professor natural join User where userId = professorId";
            this.statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = this.statement.executeQuery();

            while(resultSet.next()) {
                Professor professor = new Professor();
                professor.setUserId(resultSet.getString(1));
                professor.setName(resultSet.getString(2));
                professor.setGender(Gender.stringToGender(resultSet.getString(3)));
                professor.setDepartment(resultSet.getString(4));
                professor.setPosition(resultSet.getString(5));
                professor.setAddress(resultSet.getString(6));
                professor.setRole(Role.PROFESSOR);
                professor.setPassword("*********");
                professorList.add(professor);
            }

            System.out.println(professorList.size() + " professors in the institute.");
        } catch (SQLException var5) {
            System.out.println("Error: " + var5.getMessage());
        }

        return professorList;
    }

    public void setGeneratedReportCardTrue(String StudentId) {
        String sql1 = "update student set isReportGenerated = 1 where StudentId = ?";

        try {
            this.statement = this.connection.prepareStatement(sql1);
            this.statement.setString(1, StudentId);
            int var3 = this.statement.executeUpdate();
        } catch (SQLException var4) {
            System.out.println("Error: " + var4.getMessage());
        }

    }

    public List<RegisteredCourse> generateGradeCard(String StudentId) {
        List<RegisteredCourse> CoursesOfStudent = new ArrayList();

        try {
            String sql = " select * from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.StudentId = ?";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1, StudentId);
            ResultSet resultSet = this.statement.executeQuery();

            while(resultSet.next()) {
                Course course = new Course(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getString(3));
                RegisteredCourse temp = new RegisteredCourse();
                temp.setCourseId(course.getCourseId());
                temp.setStudentId(StudentId);
                temp.setGrade(new Grade(resultSet.getString(8)));
                CoursesOfStudent.add(temp);
                System.out.println("Graded");
            }

            String sql1 = "update student set isReportGenerated = 1 where StudentId = ?";
            this.statement = this.connection.prepareStatement(sql1);
            this.statement.setString(1, StudentId);
            int var9 = this.statement.executeUpdate();
        } catch (SQLException var7) {
            System.out.println("Error: " + var7.getMessage());
        }

        return CoursesOfStudent;
    }
}
