package com.flipkart.dao;

import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDaoImpl implements StudentDaoInterface {
    private static volatile StudentDaoImpl instance = null;
    private PreparedStatement statement = null;
    Connection connection = DBUtils.getConnection();
    private StudentDaoImpl() {}

    public static StudentDaoImpl getInstance(){
        if(instance == null) {
            synchronized(StudentDaoImpl.class) {
                instance = new StudentDaoImpl();
            }
        }
        return instance;
    }
}
