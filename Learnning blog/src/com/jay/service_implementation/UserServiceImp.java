package com.jay.service_implementation;
import java.sql.PreparedStatement;

import com.java.connection_provider.Db_Connection;
import com.jay.services.UserServices;
import com.jay.entity.User;
import com.jay.dao.Userdao;
public class UserServiceImp implements UserServices {

	@Override
	public boolean save(User u) {
		Userdao ud=new Userdao(Db_Connection.getconnection());
		boolean i=false;
	 i=	ud.saveuser(u);
	
	System.out.println(i);	
		
	
	return i;	
	}
	public User getUserByEmailAndPassword(String email, String password)
	{
		Userdao ud=new Userdao(Db_Connection.getconnection());	
		
	return 	ud.getUserByEmailAndPassword(email, password);
		
	}
	public boolean updateUser(User u)
	{

		
		  boolean f=false;
		  Userdao ud=new Userdao(Db_Connection.getconnection());
		 f=ud.updateUser(u);
		
		
		

	return f;	
	}

}
