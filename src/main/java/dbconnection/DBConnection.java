package dbconnection;

import java.sql.*;

public class DBConnection {
    public static final String Driver="com.mysql.cj.jdbc.Driver";
    public static final String PATH="jdbc:mysql://localhost:3306/jsp";
    public static final String USER="root";
    public static final String PASSWORD="";
    Connection connection;
    public void openConnection(){
        try {
            Class.forName(Driver);
            connection= DriverManager.getConnection(PATH,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public PreparedStatement getPreparedStatement(String query){
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
    }
}
