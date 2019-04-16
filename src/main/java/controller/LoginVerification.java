package controller;

import dao.Dao;
import daoImpl.DaoImpl;
import dbconnection.DBConnection;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="LoginVerification",urlPatterns = "/loginVerification")
public class LoginVerification extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in ver");
        DBConnection dbConnection=new DBConnection();
        dbConnection.openConnection();
        String query="Select * from login where username=? and password=?";
        PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setString(1,req.getParameter("userName"));
            preparedStatement.setString(2,req.getParameter("password"));
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                Dao<Person> personDao=new DaoImpl();
                List<Person> personList=personDao.findAll();
                req.setAttribute("personList",personList);
                req.setAttribute("isTrue",true);
                req.getRequestDispatcher("displayAll.jsp").forward(req,resp);
            }
            else{
                req.setAttribute("isTrue",false);
                req.getRequestDispatcher("Index.html").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
