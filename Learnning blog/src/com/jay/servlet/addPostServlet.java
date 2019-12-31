package com.jay.servlet;
import com.java.connection_provider.Db_Connection;
import com.jay.dao.Postdao;
import com.jay.entity.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jay.entity.User;
@MultipartConfig
@WebServlet("/addPostServlet")
public class addPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public addPostServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		 String pTitle = request.getParameter("pTitle");
		 String pContent = request.getParameter("pContent");
		 String pPic = request.getParameter("pPic");
		 String pCode = request.getParameter("pCode");
		 int cid = Integer.parseInt(request.getParameter("cid"));
		 HttpSession Session=request.getSession();
	       User user=(User) Session.getAttribute("currentUser");
		 Post p=new Post(pTitle,pContent, pCode,"defalt.png", null,cid, user.getId());
		 Postdao pd=new Postdao(Db_Connection.getconnection());
		 if(pd.savePost(p))
		 {
			 
			out.print("done"); 
			 
		 }
		 else
		 {
			 out.print("failed");  
			 
		 }
		 
		 
		 
		 
		 
	}

}
