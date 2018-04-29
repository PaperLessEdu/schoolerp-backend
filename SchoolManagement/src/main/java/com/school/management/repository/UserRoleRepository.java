package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long>{
	
}

