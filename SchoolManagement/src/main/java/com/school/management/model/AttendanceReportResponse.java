package com.school.management.model;

/**
 * com.school.management.model.AttendanceReportResponse
 * 
 * @author Pavan.Pawar
 *
 */
public class AttendanceReportResponse {

	private Long student_id;

	private Long absentDays;

	public AttendanceReportResponse(Long student_id, Long absentDays) {
		super();
		this.student_id = student_id;
		this.absentDays = absentDays;
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public Long getAbsentDays() {
		return absentDays;
	}

	public void setAbsentDays(Long absentDays) {
		this.absentDays = absentDays;
	}

	@Override
	public String toString() {
		return "AttendanceReportResponse [student_id=" + student_id + ", absentDays=" + absentDays + "]";
	}

}
