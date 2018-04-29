package com.school.management.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.school.management.domain.Employee;
import com.school.management.model.AddToEmployeeRequest;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.EmployeeService;

@RestController
@RequestMapping(value =  UriConstants.EMPLOYEES)
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addEmployee(@RequestBody AddToEmployeeRequest addToEmployeeRequest) {

		logger.info("Request received to add Employee with first name [{}] and last name [{}]",addToEmployeeRequest.getFirstName(), addToEmployeeRequest.getLastName());
		
		SmResponseStatus smResponseStatus = null;
		if (addToEmployeeRequest.getFirstName() == null || addToEmployeeRequest.getLastName() == null) {
			String error = String.format("Employee first name or last name can not empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = employeeService.addEmployee(addToEmployeeRequest);
		
		logger.info("Employee Sucessfully added with first name [{}] and last name [{}]",addToEmployeeRequest.getFirstName(), addToEmployeeRequest.getLastName());
		return smResponseStatus;

	}
	
	@RequestMapping(value = UriConstants.EMPLOYEEID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteEmployee(@PathVariable Long employeeId) {
		
		logger.info("Request received to delete Employee with id [{}]", employeeId);
		
		SmResponseStatus smResponseStatus = null;
		
		if(employeeId == null) {
			String error = String.format("Employee id can not be null/empty or zero");
			logger.error(error);
			throw new CustomException(error);
		}
		Boolean isExist = employeeService.existsById(employeeId);
		
		if(isExist.equals(Boolean.FALSE)) {
			String error = String.format("Employee with id [%s] is not exist so aborting the delete employee operation",employeeId);
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = employeeService.deleteEmployee(employeeId);
		
		logger.info("Employee deleted Successfully with id [{}]",employeeId);
		return smResponseStatus;
		
	}
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Employee> getEmployeeList() {

		logger.info("Request received to fetch Employee List");
		
		List<Employee> employeeList = new ArrayList<>();

		employeeList = employeeService.getEmployeeList();
		
		logger.info("Employee List fetched successfully");
		
		return employeeList;

	}

}
