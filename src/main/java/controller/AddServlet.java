package controller;

import dao.Dao;
import daoImpl.DaoImpl;
import model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name="AddServlet",urlPatterns = "/addServlet")
public class AddServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        Dao<Person> personDao=new DaoImpl();
        boolean isSaved=personDao.add(new Person(id,fname,lname));
        if(isSaved){
            request.setAttribute("isSaved",true);
        }
        List<Person> personList=personDao.findAll();
        request.setAttribute("personList",personList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayAll.jsp");
       requestDispatcher.forward(request,response);
    }
}
