package com.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.management.domain.Attendance;
import com.school.management.model.AttendanceReportResponse;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	//SELECT student_id ,count(student_id) FROM `attendance` WHERE `division_id`=6 and `standard_id` =1 group By `student_id`
	//@Query("SELECT p FROM Attendance p WHERE standard =:standard or division=:division")
	@Query("SELECT " +
		       "    new com.school.management.model.AttendanceReportResponse(v.student.student_id, count(v)) " +
		       "FROM " +
		       "    Attendance v  WHERE (v.standard.standard_id = :standard AND v.division.division_id = :division) " +
		       "GROUP BY " +
		       "    v.student ")
	public List<AttendanceReportResponse> generateReport(@Param("standard") Long standard, @Param("division") Long division);

}
