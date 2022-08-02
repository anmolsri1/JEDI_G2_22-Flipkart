package com.flipkart.constant;

public class SqlQueriesConstant {
    //AdminDao Queries
    public static final String DELETE_COURSE_QUERY = "delete from Course where courseId = ?";
    public static final String ADD_COURSE_QUERY = "insert into Course(courseId, courseName, seats, professorId) values (?, ?, ?, ?)";
    public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId,name, password, type, gender, address, studentId from student, user where isApproved = 0 and studentId = userId";
    public static final String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
    public static final String ADD_USER_QUERY = "insert into user(id, name, password, type, gender, address) values (?, ?, ?, ?, ?, ?)";
    public static final String ADD_PROFESSOR_QUERY = "insert into Professor(professorId, department, designation) values (?, ?, ?)";
    public static final String ASSIGN_COURSE_QUERY = "update catalog set professorId = ? where courseId = ?";
    public static final String VIEW_COURSE_QUERY = "select courseId, courseName, professorId from catalog";
    public static final String VIEW_PROFESSOR_QUERY = "select userId, name, gender, department, designation, address from Professor natural join User where userId = professorId";
    public static final String SET_GENERATED_REPORT_CARD_TRUE = "update student set isReportGenerated = 1 where studentId = ?";
    public static final String GET_GENERATED_REPORT_CARD_TRUE = "select isReportGenerated from student where studentId = ?";
    public static final String ADD_STUDENT="insert into student (studentId,department,semester,isApproved,isReportGenerated) values (?,?,?,0,0)";
    public static final String IS_APPROVED="select isApproved from student where studentId = ? ";
    public static final String GET_STUDENT_ID="select studentId from student where userId = ? ";
    // StudentDao Queries
    //public static final String GET_COURSES_OF_STUDENT="select * from";
    public static final String VIEW_REGISTERED_COURSES=" select * from course inner join registeredCourse on course.courseId = registeredCourse.courseId where registeredCourse.studentId = ?";
    public static final String VIEW_AVAILABLE_COURSES=" select * from course where courseId not in  (select courseId  from registeredCourse where studentId = ?) and seats > 0";
    public static final String CHECK_COURSE_AVAILABILITY=" select courseId from registeredCourse where studentId = ? ";
    public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseId = ? ";
    public static final String ADD_COURSE="insert into registeredCourse (studentId,courseId,grade) values ( ? , ?, ?)";
    public static final String DROP_COURSE_QUERY = "delete from registeredCourse where courseId = ? AND studentId = ?;";
    public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where courseId = ?;";
    public static final String CALCULATE_FEES  = "select sum(courseFee) from course where courseId in (select courseId from registeredCourse where studentId = ?);";
    public static final String VIEW_GRADE = "select course.courseId,course.courseName,registeredCourse.grade from course inner join registeredCourse on course.courseId = registeredCourse.courseId where registeredCourse.studentId = ?;";
    public static final String GET_SEATS = "select seats from course where courseId = ?;";
    public static final String INSERT_PAYMENT = "insert into payment(studentId,modeofPayment,referenceId,amount) values(?,?,?,?);";
    public static final String INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
    public static final String GET_NOTIFICATION = "select * from notification where referenceId = ?;";
    public static final String GET_REGISTRATION_STATUS=" select isRegistered from student where studentId = ? ";
    public static final String SET_REGISTRATION_STATUS="update student set isRegistered = true  where studentId=?";
    public static final String GET_PAYMENT_STATUS=" select isPaid from student where studentId = ? ";
    public static final String SET_PAYMENT_STATUS="update student set isPaid = true  where studentId=?";
    public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from registeredCourse where studentId = ? ";
    public static final String IS_REGISTERED=" select courseId from registeredCourse where courseId=? and studentId=? ";

    public static final String GET_GRADES = "select grade from registeredCourse where studentId=?";
    public static final String ADD_REGISTERED_COURSE = "insert into registeredCourse (studentId, courseId) VALUES(?,?)";
    public static final String DROP_REGISTERED_COURSE = "delete from registeredCourse where studentId = ? and courseId = ?";
    public static final String GET_COURSE_ID_FROM_STUDENT_ID = "select courseId from registeredCourse where studentId = ?";
    public static final String GET_COURSES_BY_ID = "select * from course where courseId = ?";
    //ProfessorDao queries

    public static final String UPDATE_PASSWORD="update user set password=? where id = ? ";
    public static final String VERIFY_CREDENTIALS="select password from user where id = ?";
    public static final String GET_ROLE="select type from user where id = ?;";
    public static final String GET_COURSES="select * from catalog where professorId=?";
    public static final String GET_ENROLLED_STUDENTS="select catalog.courseId,catalog.courseName,registeredCourse.studentId from course inner join registeredCourse on course.courseId = registeredCourse.courseId where catalog.professorId = ? order by catalog.courseId";
    public static final String ADD_GRADE="update registeredCourse set Grade=? where courseId=? and studentId=?";
    public static final String GET_PROF_NAME = "select name from user where id = ?";
    public static final String REGISTER_FOR_COURSE = "update catalogue set professorId = ? where courseId = ?";
    public static final String GET_COURSE_ID_FROM_PROF_ID = "select courseId from catalogue where professorId = ?";
}
