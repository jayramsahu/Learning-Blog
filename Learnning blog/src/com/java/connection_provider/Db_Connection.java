package com.java.connection_provider;
import java.sql.*;
public class Db_Connection {
	 private static Connection con=null;
	 public static Connection getconnection()
	 {
		 System.out.print("aa gya");
	     try
	     {
	           //driver class load
	         if(con==null){
	       Class.forName("com.mysql.jdbc.Driver");
	       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","");
	       System.out.print("pahuch gya");
	     } 
	     }
	     catch(Exception e)
	     {
	       
	       
	         e.printStackTrace();
	     
	     }
	     
	     return con;
	 }
}
