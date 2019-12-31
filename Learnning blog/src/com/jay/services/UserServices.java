package com.jay.services;
import com.jay.entity.User;
public interface UserServices {
public boolean save(User u);
public boolean updateUser(User u);
User getUserByEmailAndPassword(String email, String password);
//public void getUser();
//public void editUser();
//void deleteUser();
	
	
	
	
}
