package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.Standard;

public interface StandardRepository extends JpaRepository<Standard, Long>{

	boolean existsByName(String name);
}
