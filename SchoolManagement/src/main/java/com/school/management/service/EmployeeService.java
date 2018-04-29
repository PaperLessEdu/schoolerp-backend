package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.EmployeeDaoImpl;
import com.school.management.dao.UserDaoImpl;
import com.school.management.dao.UserRoleDaoImpl;
import com.school.management.domain.Employee;
import com.school.management.domain.User;
import com.school.management.domain.UserRole;
import com.school.management.model.AddToEmployeeRequest;
import com.school.management.model.SmResponseStatus;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeImpl;
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private UserRoleDaoImpl userRoleDaoImpl;

	public static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public SmResponseStatus addEmployee(AddToEmployeeRequest addToEmployeeRequest) {

		String message = null;
		Boolean isRoleExist = null;

		try {

			Employee employee = new Employee();
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
			employeeImpl.saveEmployee(employee);

			logger.info("Employee saved Sucessfully with First name [{}] and Last name [{}]",employee.getFirstName(), employee.getLastName());
			
			isRoleExist = userRoleDaoImpl.isExist(addToEmployeeRequest.getRoleId());
			logger.info("Output [{}]",isRoleExist);
			if(isRoleExist.equals(Boolean.FALSE)) {
				String error = String.format("User Role is not present with id [%s]", addToEmployeeRequest.getRoleId());
				logger.error(error);
				throw new CustomException(error);
			}
			
			UserRole userRole = userRoleDaoImpl.getUserRole(addToEmployeeRequest.getRoleId());
			
			User user = new User();
			user.setUserName(employee.getFirstName() + employee.getLastName());
			user.setPASSWORD(employee.getFirstName() + "@123");
			user.setEmployee(employee);
			user.setUserRole(userRole);
			userDaoImpl.saveUser(user);
			
			logger.info("User data sucessfully saved with User Name [{}]",user.getUserName());
			
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

			message = String.format("Employee deleted successfully with id", employeeId);
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

	public Employee getEmployee(Long id) {

		Employee employee = null;
		try {
			employee = employeeImpl.getEmployee(id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching employee List");
			logger.error(error, e);
			throw e;
		}
		return employee;

	}

}
