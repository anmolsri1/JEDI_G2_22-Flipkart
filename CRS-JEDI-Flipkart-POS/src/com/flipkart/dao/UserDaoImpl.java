package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;

public class UserDaoImpl implements UserDaoInterface {
    private static volatile UserDaoImpl instance=null;

    /**
     * Default Constructor
     */
    private UserDaoImpl()
    {

    }

    /**
     * Method to make UserDaoImpl Singleton
     * @return
     */
    public static UserDaoImpl getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized(UserDaoImpl.class){
                instance=new UserDaoImpl();
            }
        }
        return instance;
    }

    /**
     * Method to update password of user in DataBase
     * @param userId
     * @param newPassword
     * @return Update Password operation Status
     */
    @Override
    public boolean updatePassword(String userId, String newPassword) {
        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_PASSWORD);

            statement.setString(1, newPassword);
            statement.setString(2, userId);

            int row = statement.executeUpdate();

            if(row==1)
                return true;
            else
                return false;
        }
        catch(SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
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
     * Method to verify credentials of Users from DataBase
     * @param userId
     * @param password
     * @return Verify credentials operation status
     * @throws UserNotFoundException
     */
    @Override
    public boolean verifyCredentials(String userId, String password) throws UserNotFoundException {
        Connection connection = DBUtils.getConnection();
        try
        {
            //open db connection
            PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstant.VERIFY_CREDENTIALS);
            preparedStatement.setString(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Info: " + "inside verify");

            if(!resultSet.next())
                throw new UserNotFoundException(userId);

            else if(password.equals(resultSet.getString("password")))
            {
                System.out.println("Info: " + "inside equals");
                return true;
            }
            else
            {
                return false;
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Error: " + "Something went wrong, please try again! "+ ex.getMessage());
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
     * Method to get RoleConstant of User from DataBase
     * @param userId
     * @return RoleConstant
     */
    @Override
    public String getRole(String userId)
    {
        Connection connection = DBUtils.getConnection();
        try {
            System.out.println("Info: " + userId);
            connection=DBUtils.getConnection();

            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_ROLE);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            System.out.println("Info: query executed");

            if(rs.next())
            {
                System.out.println("Info: " + rs.getString("role"));
                return rs.getString("role");
            }

        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());

        }

        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
        }
        return null;
    }


}