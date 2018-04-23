package com.school.management.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.management.domain.User;
import com.school.management.model.SmResponseStatus;
import com.school.management.repository.UserRepository;

@Service
public class UserService {
	
	@Resource(name = "userRepository")
	private UserRepository userRepository;
	
	public SmResponseStatus addUser(String userName, String email) {
		String message = null;
		
		try {
			User user = new User();
			user.setUserName(userName);
			user.setEmail(email);
			userRepository.save(user);
			message = String.format("New Used added with UserName [%s] and Email [%s]", userName, email);
		} catch(Exception e) {
			
		}
		return new SmResponseStatus(message);
	}

}
