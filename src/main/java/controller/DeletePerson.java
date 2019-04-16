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
import java.util.List;

@WebServlet(name="DeletePerson",urlPatterns = "/delServlet")
public class DeletePerson extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao<Person> personDao=new DaoImpl();
        boolean isSaved=personDao.delete(Integer.parseInt(request.getParameter("id")));
        if(isSaved){
            request.setAttribute("isSaved",true);
        }
        List<Person> personList=personDao.findAll();
        request.setAttribute("personList",personList);
        request.getRequestDispatcher("/displayAll.jsp").forward(request,response);
    }
}
