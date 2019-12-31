package com.jay.servlet;
import com.jay.dao.Userdao;
import com.jay.entity.Message;
import com.jay.entity.User;
import com.jay.service_implementation.UserServiceImp;
import com.jay.services.UserServices;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		 String name = request.getParameter("user_name");
         String email = request.getParameter("user_email");
         String password = request.getParameter("user_password");
         String about = request.getParameter("about");
       Part p = request.getPart("image");
       String imagename= "defalt.png";
       HttpSession Session=request.getSession();
       User user=(User) Session.getAttribute("currentUser");
       user.setEmail(email);
       user.setName(name);
       user.setPassword(password);
       user.setAbout(about);
       user.setProfile(imagename);
       UserServices us=new UserServiceImp();
       boolean f= us.updateUser(user);
       PrintWriter out=response.getWriter();
       if(f)
       {
          //  response.sendRedirect("http://localhost:8050/Learnning/login.jsp"); 
        
         Message msg = new Message("profile uploaded....!", "success", "alert-success");
        
         Session.setAttribute("msg", msg);
         response.sendRedirect("profile.jsp");
       }
       
      else
       {
    	  Message msg = new Message("Something went wrong", "error", "alert-danger");
          
          Session.setAttribute("msg", msg);
          response.sendRedirect("profile.jsp");
       }
      }
		
	}


