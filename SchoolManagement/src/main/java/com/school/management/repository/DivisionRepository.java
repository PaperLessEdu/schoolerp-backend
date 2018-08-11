package com.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.management.domain.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {

	boolean existsByName(String name);
	
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 'true' ELSE 'false' END FROM division divs WHERE divs.name= :name AND divs.standard_id= :standard_id",
			nativeQuery = true)
	boolean existsByNameAndStandard_id(@Param("name") String name, @Param("standard_id")Long standard_id);
	
	@Query(value = "SELECT * FROM division std WHERE std.standard_id = :standard_id",
			nativeQuery = true)
	public List<Division> findByStandardStandard_id(@Param("standard_id") Long standard_id);
}
