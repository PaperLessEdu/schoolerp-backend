package com.school.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.domain.User;
import com.school.management.model.SmResponseStatus;
import com.school.management.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public SmResponseStatus addUser(String userName, String email) {
		String message = null;
		
		try {
			User user = new User();
			user.setUserName(userName);
			userRepository.save(user);
			message = String.format("New Used added with UserName [%s] and Email [%s]", userName, email);
		} catch(Exception e) {
			
		}
		return new SmResponseStatus(message);
	}

}
