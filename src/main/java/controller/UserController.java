package controller;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name="UserController",urlPatterns = "/userController")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        String action = req.getParameter("action");
        System.out.println("action: "+action);
        if (action.equals("login")) {
            boolean login = userDao.verifyLogin(req.getParameter("username"), req.getParameter("password"));
            System.out.println("Inside verify login do post");
            if (login == true) {
                System.out.println("Login Successful");
                req.setAttribute("title","Person List");
                req.setAttribute("isTrue", true);
                req.getRequestDispatcher("/").forward(req, resp);
            } else {
                System.out.println("Access denied");
                req.setAttribute("isError","true");
                req.setAttribute("error","Invalid username password!!");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        }
        else if(action.equals("signup")){
            System.out.println("Inside signup");
            int id=Integer.parseInt(req.getParameter("id"));
            String fname=req.getParameter("fname");
            String lname=req.getParameter("lname");
            String uname=req.getParameter("username");
            String psw=req.getParameter("password");
            String contact=req.getParameter("contact");
            boolean signup=userDao.add(new User(id,uname,psw,fname,lname,contact));
            if(signup==true){
                req.setAttribute("isTrue","true");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        }
    }
}
