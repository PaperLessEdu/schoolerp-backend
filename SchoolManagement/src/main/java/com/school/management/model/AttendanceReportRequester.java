package com.school.management.model;

/**
 * 
 * @author Pavan.Pawar
 *
 */
public class AttendanceReportRequester {
	
	private Long month;

	private Long standard_id;

	private Long division_id;

	public Long getStandard_id() {
		return standard_id;
	}

	public void setStandard_id(Long standard_id) {
		this.standard_id = standard_id;
	}

	public Long getDivision_id() {
		return division_id;
	}

	public void setDivision_id(Long division_id) {
		this.division_id = division_id;
	}
	

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "AttendanceReportRequester [month=" + month + ", standard_id=" + standard_id + ", division_id="
				+ division_id + "]";
	}

}
