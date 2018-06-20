package com.school.management.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.school.management.domain.AcademicYear;

/**
 * 
 * @author Pavan.Pawar
 *
 */
public class AcademicYearModel {
	private long academicYearId;

	private String name;
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private Date endDate;
	private String weekendType;
	private boolean isCurrent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getWeekendType() {
		return weekendType;
	}

	public void setWeekendType(String weekendType) {
		this.weekendType = weekendType;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

	public long getAcademicYearId() {
		return academicYearId;
	}

	public void setAcademicYearId(long academicYearId) {
		this.academicYearId = academicYearId;
	}

	@Override
	public String toString() {
		return "AcademicYearModel [academicYearId=" + academicYearId + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", weekendType=" + weekendType + ", isCurrent=" + isCurrent + "]";
	}

	public void wrapDetails(AcademicYear academicYear) {
		this.endDate = academicYear.getEndDate();
		this.name = academicYear.getName();
		this.startDate = academicYear.getStartDate();
		this.weekendType = academicYear.getWeekendType();
		this.isCurrent = academicYear.isCurrent();
		this.academicYearId = academicYear.getAcademicYearId();
	}
}
