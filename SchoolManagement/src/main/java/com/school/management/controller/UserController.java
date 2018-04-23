package com.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.SmResponseStatus;
import com.school.management.service.UserService;

@RestController
@RequestMapping(path="/school")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path="/addUser") // Map ONLY POST Requests
	public SmResponseStatus addUser(@RequestParam String userName, @RequestParam String email) {
		String message = null;
		
		try {
			userService.addUser(userName, email);
		} catch(Exception e) {
			
		}
		return new SmResponseStatus(message);
	}
}
