package com.school.management.dao;

import java.util.Date;
import java.util.List;

import com.school.management.domain.Attendance;
import com.school.management.model.AttendanceReportResponse;

public interface AttendanceDao {

	public void saveAttendance(Attendance attendance);

	public boolean isExistById(String is_present);

	public boolean existsById(Long attendance_id);

	public Attendance getAttendance(Long attendance_id);

	public List<Attendance> getAttendanceList();

	public void deleteAttendance(Long attendance_id);

	public void updateAttendance(Attendance attendance);

	public List<AttendanceReportResponse> getAtttendanceReport(Long standardId, Long divisionId);

	public List<AttendanceReportResponse> getAtttendanceReportWithDate(Long standardId, Long divisionId, Date startDate,
			Date endDate);

}
