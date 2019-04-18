package daoImpl;

import dao.Dao;
import dao.UserDao;
import dbconnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements Dao<User>,UserDao<User> {
    DBConnection dbConnection=new DBConnection();
    @Override
    public boolean verifyLogin(String userName, String password) {
        System.out.println("Inside verify login method");
        dbConnection.openConnection();
        String query="Select * from user where username=? and password=?";
        PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public boolean add(User user) {
       dbConnection.openConnection();
       String query="insert into user values(?,?,?,?,?,?)";
       PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getFirstname());
            preparedStatement.setString(3,user.getLastname());
            preparedStatement.setString(4,user.getUsername());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getContact());
            int check=preparedStatement.executeUpdate();
            if(check>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection();
        return false;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
