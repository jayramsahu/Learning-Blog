package com.jay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jay.entity.*;
import com.jay.service_implementation.UserServiceImp;
import com.jay.services.UserServices;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	
		 String userEmail = request.getParameter("email");
         String userPassword = request.getParameter("password");
         UserServices dao = new UserServiceImp();

         User u = dao.getUserByEmailAndPassword(userEmail, userPassword);

         if (u == null) {
             //login.................
//             error///
//             out.println("Invalid Details..try again");
             Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
             HttpSession s = request.getSession();
             s.setAttribute("msg", msg);

             response.sendRedirect("login.jsp");
         } else {
             //......
//             login success
             HttpSession s = request.getSession();
             s.setAttribute("currentUser", u);
             response.sendRedirect("profile.jsp");

         }
	
		
		
	}

}
