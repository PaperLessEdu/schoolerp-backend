package com.school.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Employee;
import com.school.management.repository.EmployeeRepository;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

	public static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public void saveEmployee(Employee employee) {
		
		try {
			employeeRepository.save(employee);
		}catch(Exception e) {
			String error  = String.format("Error occured while saving Employee with Firstname [%s] and LastName[%s]",employee.getFirstName(), employee.getLastName());
			logger.error(error);
			throw e;
		}
	}


	@Override
	public void deleteEmployee(Long id) {
		
		try {
			employeeRepository.deleteById(id);
		} catch(Exception e) {
			String error = String.format("Error occured while deleting employee with id [%s]", id);
			logger.error(error);
			throw e;
		}
		
	}


	@Override
	public Boolean existsById(Long id) {
		
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = employeeRepository.existsById(id);
			
		} catch(Exception e) {
			String error = String.format("Error occured while checking employee with id [%s]", id);
			logger.error(error);
			isExist = Boolean.FALSE;
			throw e;
		}
		return isExist;
	}


	@Override
	public List<Employee> getEmployeeList() {
		
		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList = employeeRepository.findAll();
		} catch(Exception e) {
			String error = String.format("Error occured while fetching employee list");
			logger.error(error);
			throw e;
		}
		return employeeList;
	}


	@Override
	public Employee getEmployee(Long id) {
		Employee employee = new Employee();
		try {
			employee = employeeRepository.getOne(id);                                                 
		} catch(Exception e) {
			String error = String.format("Error occured while fetching employee details");
			logger.error(error);
			throw e;
		}
		return employee;
	}

}
