package com.school.management.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.school.management.domain.Holiday;

public class HolidayModel {

	private String name;

	private Long holiday_id;

	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date date;

	private String discription;

	public Long getHoliday_id() {
		return holiday_id;
	}

	public void setHoliday_id(Long holiday_id) {
		this.holiday_id = holiday_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public void wrapDetails(Holiday holiday) {
		this.holiday_id = holiday.getHoliday_id();
		this.name = holiday.getName();
		this.discription = holiday.getDiscription();
		this.date = holiday.getDate();

	}

}