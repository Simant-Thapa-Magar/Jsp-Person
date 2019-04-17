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

@WebServlet(name="person", urlPatterns = {"/","/updateServlet","/addServlet","/delServlet"})
public class PersonController extends HttpServlet {
    Dao<Person> dao = new DaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action!=null && action.equals("DELETE")){
            System.out.println("inside delete");
            boolean isSaved=dao.delete(Integer.parseInt(req.getParameter("id")));
            if(isSaved){
                req.setAttribute("isSaved",true);
            }
            List<Person> personList=dao.findAll();
            req.setAttribute("personList",personList);
        }
        else if(action!=null && action.equals("UPDATE")){
            System.out.println("inside update");
            Person person=dao.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("person",person);
            req.getRequestDispatcher("updatePerson.jsp").forward(req,resp);
        }
        else if(action!=null && action.equals("ADD")){
            System.out.println("inside add");
            int id=Integer.parseInt(req.getParameter("id"));
            String fname=req.getParameter("fname");
            String lname=req.getParameter("lname");
            boolean isSaved=dao.add(new Person(id,fname,lname));
            if(isSaved){
                req.setAttribute("isSaved",true);
            }
            List<Person> pList=dao.findAll();
            req.setAttribute("personList",pList);
        }
        else {
            List<Person> personList = dao.findAll();
            req.setAttribute("personList", personList);
            System.out.println("no action found");
        }
        System.out.println("person controller");
        RequestDispatcher rd=req.getRequestDispatcher("displayAll.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        Person person=new Person(Integer.parseInt(req.getParameter("id")),req.getParameter("fname"),req.getParameter("lname"));
        boolean isSaved=dao.update(person);
        if(isSaved){
            req.setAttribute("isSaved",true);
        }
        req.setAttribute("personList",dao.findAll());
    }
}
