package com.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.SmResponseStatus;
import com.school.management.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path="/school")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(path="/addUser") // Map ONLY POST Requests
	public SmResponseStatus addUser(@RequestParam String userName, @RequestParam String email) {
		String message = null;
		logger.info("Request received to add user details");
		try {
			userService.addUser(userName, email);
		} catch(Exception e) {
			message = String.format("Failed to save the user");
			logger.error(message);
		}
		return new SmResponseStatus(message);
	}
}
