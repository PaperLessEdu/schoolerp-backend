package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}