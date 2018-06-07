package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Attendance;

public interface AttendanceDao {

	public void saveAttendance(Attendance attendance);

	public boolean isExistById(String is_present);

	public boolean existsById(Long attendance_id);

	public Attendance getAttendance(Long attendance_id);

	public List<Attendance> getAttendanceList();

	public void deleteAttendance(Long attendance_id);

	public void updateAttendance(Attendance attendance);

}
