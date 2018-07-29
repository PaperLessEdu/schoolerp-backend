package com.school.management.model;

import java.util.Date;
import java.util.List;

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

	private Date startdate;
	private Date enddate;

	private List<Date> date;

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

	


	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public List<Date> getDate() {
		return date;
	}

	public void setDate(List<Date> date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AttendanceReportResponse [student_id=" + student_id + ", absentDays=" + absentDays + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", date=" + date + "]";
	}

}
