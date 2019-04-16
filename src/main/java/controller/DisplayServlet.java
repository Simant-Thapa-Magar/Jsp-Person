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

@WebServlet(name="DisplayServlet",urlPatterns = "/displayAll")
public class DisplayServlet extends HttpServlet {
        public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                 Dao<Person> dao = new DaoImpl();
                List<Person> personList;
                personList = dao.findAll();
                req.setAttribute("personList",personList);
                RequestDispatcher rd=req.getRequestDispatcher("displayAll.jsp");
                rd.forward(req,res);
        }
}
