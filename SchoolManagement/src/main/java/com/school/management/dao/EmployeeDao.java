package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Employee;

public interface EmployeeDao {
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(Long id);
	
	public Boolean existsById(Long id);
	
	public List<Employee> getEmployeeList();
	
	public Employee getEmployee(Long id);
	
}
