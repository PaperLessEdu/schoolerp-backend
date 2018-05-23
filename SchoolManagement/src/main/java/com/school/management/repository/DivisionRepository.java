package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.domain.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>{
	boolean existsByName(String name);
}
