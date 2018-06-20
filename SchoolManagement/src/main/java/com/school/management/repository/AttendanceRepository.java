package com.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.management.domain.Attendance;
import com.school.management.domain.Division;
import com.school.management.domain.Standard;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	@Query("SELECT p FROM Attendance p WHERE standard =:standard or division=:division")
	public List<Attendance> generateReport(@Param("standard") Standard standard, @Param("division") Division division);

}
