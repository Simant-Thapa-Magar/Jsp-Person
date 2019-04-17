package daoImpl;

import dao.Dao;
import dbconnection.DBConnection;
import model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao<Person> {
    List<Person> personList=new ArrayList<>();
    DBConnection dbConnection=new DBConnection();
    @Override
    public List findAll() {
        dbConnection.openConnection();
        String query="Select * from person";
        PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            ResultSet resultSet=preparedStatement.executeQuery();
            if(personList.isEmpty()!=true){
                personList.removeAll(personList);
            }
            while(resultSet.next()){
                personList.add(new Person(resultSet.getInt("id"),resultSet.getString("fname"),resultSet.getString("lname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection();
        return personList;
    }

    @Override
    public boolean add(Person person) {
        dbConnection.openConnection();
        String query="insert into person values(?,?,?)";
        PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setInt(1,person.getId());
            preparedStatement.setString(2,person.getFname());
            preparedStatement.setString(3,person.getLname());
            int test=preparedStatement.executeUpdate();
            if(test>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection();
        return false;
    }

    @Override
    public Person findById(int id) {
        dbConnection.openConnection();
        String query="select * from person where id=?";
        PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection();
        return null;
    }

    @Override
    public boolean delete(int id) {
        dbConnection.openConnection();
        String query="delete from person where id=?";
        PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setInt(1,id);
            int test=preparedStatement.executeUpdate();
            if(test>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection();
        return false;
    }

    @Override
    public boolean update(Person person) {
        dbConnection.openConnection();
        String query="update person set fname=?,lname=? where id=?";
        PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setString(1,person.getFname());
            preparedStatement.setString(2,person.getLname());
            preparedStatement.setInt(3,person.getId());
            int test=preparedStatement.executeUpdate();
            if(test>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection();
        return false;
    }
}
