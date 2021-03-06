package com.school.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.UserRole;
import com.school.management.repository.UserRoleRepository;

@Component
public class UserRoleDaoImpl implements UserRoleDao{
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(UserRoleDaoImpl.class);

	@Override
	public void saveRole(UserRole userRole) {
		
		try {
			userRoleRepository.save(userRole);
		} catch(Exception e) {
			String error = String.format("Error occured while saving user role");
			logger.error(error);
			throw e;
		}
		
	}

	@Override
	public boolean isExist(Long roleId) {
		
		boolean isExist = false;
		try {
			isExist = userRoleRepository.existsById(roleId);
		} catch(Exception e) {
			String error = String.format("Error occured while checking user role existance");
			logger.error(error);
			throw e;
		}
		return isExist;
	}

	@Override
	public UserRole getUserRole(Long userRoleId) {
		
		UserRole userRole = new UserRole();
		try {
			userRole = userRoleRepository.getOne(userRoleId);
		} catch(Exception e) {
			String error = String.format("Error occured while fetching User Role");
			logger.error(error);
			throw e;
		}
		return userRole;
	}

	@Override
	public void deleteRole(Long roleId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<UserRole> getUserRoleList() {
		
		List<UserRole> userRoleList = new ArrayList<>();
		try {
			userRoleList = userRoleRepository.findAll();
		} catch(Exception e) {
			String error = String.format("Error occured while fetching userRole list");
			logger.error(error);
			throw e;
		}
		return userRoleList;
	}

	/*@Override
	public void updateRole(UserRole, Long UserRoleId) {
		
		try {
			userRole = userRoleRepository.getOne(userRoleId);
		} catch(Exception e) {
			String error = String.format("Error occured while fetching User Role");
			logger.error(error);
			throw e;
		}
		return userRole;		
	}*/

	@Override
	public List<UserRole> getUserRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRole(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}

}
