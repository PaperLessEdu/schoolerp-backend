package com.school.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.core.CustomException;
import com.school.management.domain.Employee;
import com.school.management.domain.UserRole;
import com.school.management.model.AddToEmployeeRequest;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.UserRoleService;

@RestController
@RequestMapping(value = UriConstants.USERROLES)
@CrossOrigin( origins = {"http://dev.cloudscripts.co.in"}, maxAge = 4800, allowCredentials = "false")
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
	
	/**
	 * Endpoint tp get UserRole list
	 * @return		List<UserRole>
	 */
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<UserRole> getUserRoleList() {

		logger.info("Request received to fetch UserRole List");
		
		List<UserRole> userRoleList = new ArrayList<>();

		userRoleList = userRoleService.getUserRoleList();
		
		logger.info("UserRole List fetched successfully");
		
		return userRoleList;

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
