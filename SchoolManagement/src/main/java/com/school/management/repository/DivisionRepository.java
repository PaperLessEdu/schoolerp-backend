package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {

	boolean existsByName(String name);
}
