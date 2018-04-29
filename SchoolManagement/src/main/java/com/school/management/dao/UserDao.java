package com.school.management.dao;

import com.school.management.domain.User;

public interface UserDao {
	
	public void saveUser(User user);
	
	public void deleteUser(long id);
	
	
	

}
