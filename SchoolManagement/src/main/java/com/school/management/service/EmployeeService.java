package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.EmployeeDaoImpl;
import com.school.management.dao.UserRoleDaoImpl;
import com.school.management.domain.Employee;
import com.school.management.domain.UserRole;
import com.school.management.model.AddToEmployeeRequest;
import com.school.management.model.SmResponseStatus;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeImpl;
	
	@Autowired
	private UserRoleDaoImpl userRoleDaoImpl;

	public static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public SmResponseStatus addEmployee(AddToEmployeeRequest addToEmployeeRequest) {

		String message = null;
		Boolean isRoleExist = null;

		try {

			Employee employee = wrapEmployee(null, addToEmployeeRequest);
			
			UserRole userRole = userRoleDaoImpl.getUserRole(addToEmployeeRequest.getRoleId());
			
			employee.setUserRole(userRole);
			
			employee.setUserName(employee.getFirstName() + employee.getLastName());		
			
			employee.setPassword(employee.getFirstName() + "@123");
			
			employeeImpl.saveEmployee(employee);

			logger.info("Employee saved Sucessfully with First name [{}] and Last name [{}]",employee.getFirstName(), employee.getLastName());
			
			isRoleExist = userRoleDaoImpl.isExist(addToEmployeeRequest.getRoleId());
			
			if(isRoleExist.equals(Boolean.FALSE)) {
				String error = String.format("User Role is not present with id [%s]", addToEmployeeRequest.getRoleId());
				logger.error(error);
				throw new CustomException(error);
			}
			
			message = String.format("Employee saved Sucessfully with First name [%s] and Last name [%s]",
					employee.getFirstName(), employee.getLastName());
			
		} catch (Exception e) {
			String error = String.format(
					"Error occured while saving employee data with first name [%s] and last time [%s]",
					addToEmployeeRequest.getFirstName(), addToEmployeeRequest.getLastName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);

	}

	public SmResponseStatus deleteEmployee(Long employeeId) {

		String message = null;

		try {
			employeeImpl.deleteEmployee(employeeId);

			message = String.format("Employee deleted successfully with id [%s]", employeeId);
		} catch (Exception e) {
			String error = String.format("Error occured while deleting employee data with id [%s]", employeeId);
			logger.error(error, e);
			throw e;
		}

		return new SmResponseStatus(message);
	}

	public Boolean existsById(Long employeeId) {

		Boolean isExist = Boolean.FALSE;
		try {
			isExist = employeeImpl.existsById(employeeId);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching employee data with id [%s]", employeeId);
			logger.error(error, e);
			throw e;
		}
		return isExist;
	}

	public List<Employee> getEmployeeList() {

		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList = employeeImpl.getEmployeeList();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching employee List");
			logger.error(error, e);
			throw e;
		}
		return employeeList;

	}

	public AddToEmployeeRequest getEmployee(Long id) {

		Employee employee = null;
		AddToEmployeeRequest addToEmployeeRequest = new AddToEmployeeRequest();

		try {
			employee = employeeImpl.getEmployee(id);
			
			addToEmployeeRequest.wrapDetails(employee);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching employee List");
			logger.error(error, e);
			throw e;
		}
		return addToEmployeeRequest;

	}
	
	public SmResponseStatus updateEmployee(Long employeeId, AddToEmployeeRequest addToEmployeeRequest) {
		String message = null;
		Employee employee = null;
		
		try {
			
			employee = employeeImpl.getEmployee(employeeId);
			
			if(employee == null) {
				String error = String.format("Employee is not present with id [%s]", employeeId);
				logger.error(error);
				throw new CustomException(error);
			}
			
			Employee updateEmployee = wrapEmployee(employeeId,addToEmployeeRequest);
			
			UserRole userRole = userRoleDaoImpl.getUserRole(addToEmployeeRequest.getRoleId());
			
			updateEmployee.setUserRole(userRole);
			
			updateEmployee.setUserName(employee.getUserName());
			
			updateEmployee.setPassword(employee.getPassword());
			
			employeeImpl.saveEmployee(updateEmployee);

			logger.info("Employee updated Sucessfully with First name [{}] and Last name [{}]",employee.getFirstName(), employee.getLastName());
			
			message = String.format("Employee updated Sucessfully with id [%s]",employee.getId());
			
		} catch (Exception e) {
			String error = String.format(
					"Error occured while saving employee data with first name [%s] and last time [%s]",
					addToEmployeeRequest.getFirstName(), addToEmployeeRequest.getLastName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);

	}
	
	private Employee wrapEmployee(Long employeeId, AddToEmployeeRequest addToEmployeeRequest) {
		Employee employee = new Employee();
		
		if(employeeId != null ) {
			employee.setId(employeeId);
		} 
		employee.setFirstName(addToEmployeeRequest.getFirstName());
		employee.setMiddleName(addToEmployeeRequest.getMiddleName());
		employee.setLastName(addToEmployeeRequest.getLastName());
		employee.setGender(addToEmployeeRequest.getGender());
		employee.setAadharCardNumber(addToEmployeeRequest.getAadharCardNumber());
		employee.setBloodGroup(addToEmployeeRequest.getBloodGroup());
		employee.setDateOfJoining(addToEmployeeRequest.getDateOfJoining());
		employee.setDob(addToEmployeeRequest.getDob());;
		employee.setJobType(addToEmployeeRequest.getJobType());
		employee.setMaritalStatus(addToEmployeeRequest.getMaritalStatus());
		employee.setNationality(addToEmployeeRequest.getNationality());
		employee.setOccupation(addToEmployeeRequest.getOccupation());
		employee.setQualification(addToEmployeeRequest.getQualification());
		employee.setEmailId(addToEmployeeRequest.getEmailId());
		employee.setPermanentAddress(addToEmployeeRequest.getPermanentAddress());
		employee.setPhoneNumber(addToEmployeeRequest.getPhoneNumber());
		employee.setAlternatePhoneNumber(addToEmployeeRequest.getAlternatePhoneNumber());
		employee.setCorrespondenceAddress(addToEmployeeRequest.getCorrespondenceAddress());
		employee.setCity(addToEmployeeRequest.getCity());
		employee.setState(addToEmployeeRequest.getState());
		employee.setPostalCode(addToEmployeeRequest.getPostalCode());
		employee.setEmployeeType(addToEmployeeRequest.getEmployeeType());
		
		return employee;
	}

}
