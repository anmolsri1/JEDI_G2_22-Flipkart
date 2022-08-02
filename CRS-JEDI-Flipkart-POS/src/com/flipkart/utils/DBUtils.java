package com.flipkart.utils;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBUtils {
	private static Connection connection = null;
	public static Connection getConnection() {
        if (connection != null) {
        	try {
        		if (connection.isClosed()) {
                	System.out.println("Connection closed!");
                	connection = null;
                	return getConnection();
                } else {
                	System.out.println("Connection working!");
                	return connection;
                }
        	} catch (SQLException e) {
        		System.out.println("Error: " + e.getMessage());
        		return getConnection();
        	}
        } else {
            try {
                String url = "jdbc:mysql://localhost:3306/CRSDATABASE";
                String user = "root";
                String password = "Blue_178778";
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}