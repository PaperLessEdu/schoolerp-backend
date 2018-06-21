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

	private String firstName;
	private String middleName;
	private String lastName;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "AttendanceReportResponse [student_id=" + student_id + ", absentDays=" + absentDays + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

}
