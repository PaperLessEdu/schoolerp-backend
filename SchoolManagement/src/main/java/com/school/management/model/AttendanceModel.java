package com.school.management.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.school.management.domain.Attendance;

public class AttendanceModel {

	private Long attendance_id;

	private long student;

	private ArrayList<Long> studentIds;

	private long standard;

	private long division;

	private String is_present;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	public Long getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(Long attendance_id) {
		this.attendance_id = attendance_id;
	}

	public long getStudent() {
		return student;
	}

	public void setStudent(long student) {
		this.student = student;
	}

	public long getStandard() {
		return standard;
	}

	public void setStandard(long standard) {
		this.standard = standard;
	}

	public long getDivision() {
		return division;
	}

	public void setDivision(long division) {
		this.division = division;
	}

	public String getIs_present() {
		return is_present;
	}

	public void setIs_present(String is_present) {
		this.is_present = is_present;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void wrapDetails(Attendance attendance) {
		this.attendance_id = attendance.getAttendance_id();
		this.student = attendance.getStudent().getStudent_id();
		this.standard = attendance.getStandard().getStandard_id();
		this.division = attendance.getDivision().getDivision_id();
		this.is_present = attendance.getIsPresent();
		this.date = attendance.getDate();

	}

	public ArrayList<Long> getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(ArrayList<Long> studentIds) {
		this.studentIds = studentIds;
	}

	@Override
	public String toString() {
		return "AttendanceModel [attendance_id=" + attendance_id + ", student=" + student + ", studentIds=" + studentIds
				+ ", standard=" + standard + ", division=" + division + ", is_present=" + is_present + ", date=" + date
				+ "]";
	}

}
