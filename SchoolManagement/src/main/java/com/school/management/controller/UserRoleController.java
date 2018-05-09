package com.school.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.core.CustomException;
import com.school.management.model.AddToEmployeeRequest;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.UserRoleService;

@RestController
@RequestMapping(value = UriConstants.USERROLES)
public class UserRoleController {

	public static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addUserRole(@PathVariable String role) {

		logger.info("Request received to add User Role [{}]",role);
		
		SmResponseStatus smResponseStatus = null;
		if (role == null) {
			String error = String.format("User role can not be empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = userRoleService.AddRole(role);
		
		logger.info("User Role Sucessfully added with role [{}]",role);
		return smResponseStatus;
	}
	
	@RequestMapping(value = UriConstants.ROLEID, method = RequestMethod.DELETE, produces = AppConstants.JSON)
	public SmResponseStatus deleteUserRole(@PathVariable Long roleId) {

		logger.info("Request received to add User Role [{}]",roleId);
		
		SmResponseStatus smResponseStatus = null;
		if (roleId == null) {
			String error = String.format("User role can not be empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = userRoleService.deleteRole(roleId);
		
		logger.info("User Role Sucessfully deleted with role [{}]",roleId);
		return smResponseStatus;
	}
	
	
}
