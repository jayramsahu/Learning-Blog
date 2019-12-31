package com.jay.dao;

import com.jay.entity.*;

import java.sql.*;
import java.util.ArrayList;
public class Postdao {
	Connection con;

	public Postdao(Connection con) {
		super();
		this.con = con;
	}
public	ArrayList<Category> getAllCategory()
{
	ArrayList<Category> category=new ArrayList<Category>();
	 try{
		   String query="select * from categories";
		   Statement ps=this.con.createStatement();
		   
		       ResultSet cat =   ps.executeQuery(query);
		           while(cat.next())
		           {
		        	   int cid=cat.getInt("cid");
		        	   
		        	  String name=cat.getString("name");  
		        	  String description=cat.getString("description"); 
		        	 Category c=new  Category(cid,name,description);
		        	 category.add(c);
		           }
		   }
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   }
	
return category;
}
	
public boolean savePost(Post p)
{
	 
	       boolean f=false;
	   try{
	   String query="insert into posts(pTitle,pContent,pCode,pPic,catId,uid) values (?,?,?,?,?,?) ";
	   PreparedStatement ps=this.con.prepareStatement(query);
	   ps.setString(1,p.getpTitle());
	     ps.setString(2,p.getpContent());
	       ps.setString(3,p.getpCode());
	         ps.setString(4,p.getpPic());
	           ps.setInt(5,p.getCatId());
	           ps.setInt(6,p.getUserId());
	           ps.executeUpdate();
	           f=true;
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	     return f;
}

public	ArrayList<Post> getPost()
{
	ArrayList<Post> post=new ArrayList<Post>();
	 try{
		   String query="select * from posts";
		   Statement ps=this.con.createStatement();
		   
		       ResultSet cat =   ps.executeQuery(query);
		           while(cat.next())
		           {
		        	   int pid=cat.getInt("pid");
		        	   
		        	  String pTitle=cat.getString("pTitle");  
		        	  String pContent=cat.getString("pContent"); 
		        	  String pCode=cat.getString("pCode"); 
		        	  String pPic=cat.getString("pPic"); 
		        	  Timestamp pDate=cat.getTimestamp("pDate"); 
		        	  int catId=cat.getInt("catId");
		        	  int uid=cat.getInt("uid");
		        	 Post c=new Post(pid, pTitle,  pContent, pCode,pPic,pDate,catId,uid);
		        	 post.add(c);
		           }
		   }
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   }
	
return post;
}

public	ArrayList<Post> getSelectedCategoryPost(int catId)
{
	ArrayList<Post> post=new ArrayList<Post>();
	 try{
		   String query="select * from posts where catId=?";
		   PreparedStatement pstmt = con.prepareStatement(query);
           pstmt.setInt(1, catId);
          

           ResultSet cat=pstmt.executeQuery();
           
       
		  
		           while(cat.next())
		           {
		        	   int pid=cat.getInt("pid");
		        	   
		        	  String pTitle=cat.getString("pTitle");  
		        	  String pContent=cat.getString("pContent"); 
		        	  String pCode=cat.getString("pCode"); 
		        	  String pPic=cat.getString("pPic"); 
		        	  Timestamp pDate=cat.getTimestamp("pDate"); 
		        	
		        	  int uid=cat.getInt("uid");
		        	 Post c=new Post(pid, pTitle,  pContent, pCode,pPic,pDate,catId,uid);
		        	 post.add(c);
		           }
		   }
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   }
	
return post;
}

public Post getPostBYId(int pid)
{
	Post p=null;
	   try{
		   String query="select * from  posts where pid=? ";
	//   String query="insert into posts(pTitle,pContent,pCode,pPic,catId,uid) values (?,?,?,?,?,?) ";
	   PreparedStatement ps=this.con.prepareStatement(query);
	   ps.setInt(1,pid);
	   ResultSet cat=ps.executeQuery();
	   if(cat.next())
	   {
		  
		   
    	   
     	  String pTitle=cat.getString("pTitle");  
     	  String pContent=cat.getString("pContent"); 
     	  String pCode=cat.getString("pCode"); 
     	  String pPic=cat.getString("pPic"); 
     	  Timestamp pDate=cat.getTimestamp("pDate"); 
     	  int catId=cat.getInt("catId");
     	  int uid=cat.getInt("uid");
     	  p=new Post(pid, pTitle,  pContent, pCode,pPic,pDate,catId,uid);
     	 
		   
	   }
	
	
	   
	   
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	     return p;

}




}
