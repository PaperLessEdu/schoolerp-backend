package com.school.management.dao;

import java.util.List;

import com.school.management.domain.UserRole;

public interface UserRoleDao {
	
	public void saveRole(UserRole userRole);
	
	public boolean isExist(Long role);
	
	public UserRole getUserRole(Long userRoleId);
	
	public void deleteRole(Long roleId);
	
	public void updateRole(UserRole userRole);
	
	public List<UserRole> getUserRoles();
	

}
