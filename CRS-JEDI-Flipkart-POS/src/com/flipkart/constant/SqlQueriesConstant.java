package com.flipkart.constant;

public class SqlQueriesConstant {
    //ProfessorDao queries

    public static final String UPDATE_PASSWORD="update user set password=? where id = ? ";
    public static final String VERIFY_CREDENTIALS="select password from user where id = ?";
    public static final String GET_ROLE="select role from user where id = ?;";
    public static final String GET_COURSES="select * from course where professorId=?";
    public static final String GET_ENROLLED_STUDENTS="select course.courseCode,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where course.professorId = ? order by course.courseCode";
    public static final String ADD_GRADE="update registeredcourse set Grade=? where courseCode=? and studentId=?";
    public static final String GET_PROF_NAME = "select name from user where id = ?";
    public static final String REGISTER_FOR_COURSE = "insert into catalogue(professorId, courseId) values(?,?)";
    public static final String GET_COURSE_ID_FROM_PROF_ID = "select courseId from catalogue where professorId = ?";
}
