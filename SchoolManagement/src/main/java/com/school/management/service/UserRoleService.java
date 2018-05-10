package com.school.management.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.school.management.dao.UserRoleDaoImpl;
import com.school.management.domain.Employee;
import com.school.management.domain.UserRole;
import com.school.management.model.SmResponseStatus;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleDaoImpl userRoleDaoImpl;

	public static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	public SmResponseStatus AddRole(@PathVariable String role) {
		String message = null;

		try {
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			
			userRoleDaoImpl.saveRole(userRole);
			
			logger.info("User Role saved successfully [{}]",role);
			
			message = String.format("User Role saved successfully with role [%s]",role);
			
		} catch (Exception e) {
			String error = String.format("Error occured while saving user role");
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);

	}
	
	public SmResponseStatus deleteRole(@PathVariable Long role) {
		
		String message = null;
		
		try {
			
			userRoleDaoImpl.deleteRole(role);
			
			logger.info("User Role deleted successfully [{}]",role);
			
			message = String.format("User Role deleted successfully with role [%s]",role);
			
		} catch (Exception e) {
			String error = String.format("Error occured while saving user role");
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}
}
