package com.jay.dao;

import com.jay.entity.User;
import java.sql.*;
public class Userdao {
	
	
	 private Connection con;
	   public  Userdao(Connection con)
	   {
	   
	   this.con=con;
	   }
	   //methos to insert user data
	   public  boolean saveuser(User u)
	   {
	       boolean f=false;
	   try{
	   String query="insert into user(name,email,password,gender,about) values (?,?,?,?,?) ";
	   PreparedStatement ps=this.con.prepareStatement(query);
	   ps.setString(1,u.getName());
	     ps.setString(2,u.getEmail());
	       ps.setString(3,u.getPassword());
	         ps.setString(4,u.getGender());
	           ps.setString(5,u.getAbout());
	           ps.executeUpdate();
	           f=true;
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	     return f;
	   }
	   public User getUserByEmailAndPassword(String email, String password) {
	        User user = null;

	        try {

	            String query = "select * from user where email =? and password=?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setString(1, email);
	            pstmt.setString(2, password);

	            ResultSet set=pstmt.executeQuery();
	            
	            if(set.next())
	            {
	             user=new User();
	             
	             
//	             data from db
	             String name=set.getString("name");
//	             set to user object
	             user.setName(name);
	             
	             user.setId(set.getInt("id"));
	             user.setEmail(set.getString("email"));
	             user.setPassword(set.getString("password"));
	             user.setGender(set.getString("gender"));
	             user.setAbout(set.getString("about"));
	             user.setDatetime(set.getTimestamp("rdate"));
	             user.setProfile(set.getString("profile"));
	             
	             
	             
	             
	                
	                
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return user;
	    }
public boolean updateUser(User u)
{

	
	  boolean f=false;
	   try{
	   String query="update user set name=?,email=?,password=?,about=?,profile=? where id=? ";
	   PreparedStatement ps=this.con.prepareStatement(query);
	   ps.setString(1,u.getName());
	     ps.setString(2,u.getEmail());
	       ps.setString(3,u.getPassword());
	       
	           ps.setString(4,u.getAbout());
	           ps.setString(5,u.getProfile());
	           ps.setInt(6,u.getId());
	           ps.executeUpdate();
	           f=true;
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	     
	
	
	

return f;	
}
	

}
