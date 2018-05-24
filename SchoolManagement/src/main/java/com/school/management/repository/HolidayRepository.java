package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {

	boolean existsByName(String name);

}
