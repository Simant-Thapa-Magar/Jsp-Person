package controller;

import dao.Dao;
import daoImpl.DaoImpl;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//@WebServlet(name="UpdateServlet",urlPatterns = "/updateServlet")
public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao<Person> personDao=new DaoImpl();
        Person person=personDao.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("person",person);
        request.getRequestDispatcher("updatePerson.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Dao<Person> personDao=new DaoImpl();
        Person person=new Person(Integer.parseInt(request.getParameter("id")),request.getParameter("fname"),request.getParameter("lname"));
        boolean isSaved=personDao.update(person);
        if(isSaved){
            request.setAttribute("isSaved",true);
        }
        request.setAttribute("personList",personDao.findAll());
        request.getRequestDispatcher("displayAll.jsp").forward(request,response);
    }
}