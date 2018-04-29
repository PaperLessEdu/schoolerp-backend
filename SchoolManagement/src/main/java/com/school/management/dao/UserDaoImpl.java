package com.school.management.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.User;
import com.school.management.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao{
	
	public static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		
		try {
			userRepository.save(user);
		} catch(Exception e) {
			String error  = String.format("Error occured while saving User with user name", user.getUserName());
			logger.error(error);
			throw e;
		}
		
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		
	}

}
