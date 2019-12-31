package com.jay.servlet;
import com.jay.services.UserServices;
import com.jay.service_implementation.UserServiceImp;
import com.jay.entity.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 @MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String check=request.getParameter("check");
        
        if(check==null)
        {
             out.println("box not checked");
        }
        else{
        
         String name = request.getParameter("user_name");
         String email = request.getParameter("user_email");
         String password = request.getParameter("user_password");
         String gender = request.getParameter("gender");
         String about = request.getParameter("about");
       
         User u=new User(name,email,password,gender,about);
       UserServices us=new UserServiceImp();
    boolean f= us.save(u);
  
        
         if(f)
         {
            //  response.sendRedirect("http://localhost:8050/Learnning/login.jsp"); 
           out.println("done");
         }
         
        else
         {
         out.println("erore");
         
         }
        }
		
		
		
		
		
		
		
		
		
	}

}
