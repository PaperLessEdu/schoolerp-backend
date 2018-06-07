package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	
	//boolean existsById(String attendance_id);

}
