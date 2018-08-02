package com.school.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.management.domain.Attendance;
import com.school.management.model.AttendanceReportResponse;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	// SELECT student_id ,count(student_id) FROM `attendance` WHERE
	// `division_id`=6 and `standard_id` =1 group By `student_id`
	// @Query("SELECT p FROM Attendance p WHERE standard =:standard or
	// division=:division")
	@Query("SELECT " + "    new com.school.management.model.AttendanceReportResponse(v.student.student_id, count(v)) "
			+ "FROM "
			+ "    Attendance v  WHERE (v.standard.standard_id = :standard AND v.division.division_id = :division) "
			+ "GROUP BY " + "    v.student ")
	public List<AttendanceReportResponse> generateReport(@Param("standard") Long standard,
			@Param("division") Long division);

	@Query("SELECT " + "    new com.school.management.model.AttendanceReportResponse(v.student.student_id, count(v)) "
			+ "FROM "
			+ "    Attendance v  WHERE (v.standard.standard_id = :standard AND v.division.division_id = :division) and (v.date BETWEEN  :startDate AND :endDate)"
			+ "GROUP BY " + "    v.student ")
	public List<AttendanceReportResponse> generateReportWithDate(@Param("standard") Long standard,
			@Param("division") Long division, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	// List<Attendance>
	// SELECT FROM Attendance v where v.standard.standard_id = :standard AND
	// v.division.division_id = :division and v.student.student_id) and and
	// (v.date BETWEEN :startDate AND :endDate)
	// getabsentdatdateofStudent(studeid,divid,stdid,startdate,enddate)

	@Query("SELECT  v  FROM Attendance v WHERE (v.standard.standard_id = :standard AND v.division.division_id = :division AND v.student.student_id = :student) AND (v.date BETWEEN  :startDate AND :endDate)")
	public List<Attendance> getabsentdateofStudent(@Param("standard") Long standard,
			@Param("division") Long division, @Param("startDate") Date startDate, @Param("endDate") Date enDate ,@Param("student") Long student);

}
