package com.school.management.dao;

import com.school.management.domain.UserRole;

public interface UserRoleDao {
	
	public void saveRole(UserRole userRole);
	
	public boolean isExist(Long role);
	
	public UserRole getUserRole(Long userRoleId);

}
