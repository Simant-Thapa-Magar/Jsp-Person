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

@WebServlet(name="PersonController", urlPatterns = {"/","/updateServlet","/addServlet","/delServlet"})
public class PersonController extends HttpServlet {
    Dao<Person> dao = new DaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        System.out.println("get action: "+action);
        if(action!=null) {
            if (action.equals("DELETE")) {
                System.out.println("inside get delete");
                boolean isSaved = dao.delete(Integer.parseInt(req.getParameter("id")));
                if (isSaved) {
                    req.setAttribute("isSaved", true);
                    req.setAttribute("message","Data Deleted !!!");
                }
                req.setAttribute("personList", dao.findAll());
                req.getRequestDispatcher("displayAll.jsp").forward(req,resp);
            } else if (action.equals("UPDATE")) {
                System.out.println("inside get update");
                Person person = dao.findById(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("title","Update Page");
                req.setAttribute("person", person);
                req.getRequestDispatcher("updatePerson.jsp").forward(req, resp);
            } else if (action.equals("ADD")) {
                System.out.println("inside get add");
                req.setAttribute("title","Add Page");
                req.getRequestDispatcher("addPerson.jsp").forward(req, resp);
            }
        }
        else{
            req.setAttribute("title","List Page");
            req.setAttribute("personList",dao.findAll());
            RequestDispatcher rd=req.getRequestDispatcher("displayAll.jsp");
            rd.forward(req,resp);
        }
        System.out.println("person controller");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        System.out.println("post action: "+action);
       if(action!=null) {
           if (action.equals("UPDATE")) {
               System.out.println("inside post update");
               Person person = new Person(Integer.parseInt(req.getParameter("id")), req.getParameter("fname"), req.getParameter("lname"));
               boolean isSaved = dao.update(person);
               if (isSaved) {
                   req.setAttribute("isSaved", true);
                   req.setAttribute("message","Data Updated !!!");
               }
               req.setAttribute("personList", dao.findAll());
               req.getRequestDispatcher("displayAll.jsp").forward(req, resp);
           }
           if (action.equals("ADD")) {
               System.out.println("inside post add");
               int id = Integer.parseInt(req.getParameter("id"));
               String fname = req.getParameter("fname");
               String lname = req.getParameter("lname");
               boolean isSaved = dao.add(new Person(id, fname, lname));
               if (isSaved) {
                   req.setAttribute("isSaved", true);
                   req.setAttribute("message","New Data Added !!!");
               }
               req.setAttribute("title","Person List");
               req.setAttribute("personList",dao.findAll());
               req.getRequestDispatcher("displayAll.jsp").forward(req, resp);
           }
       }
    }
}
