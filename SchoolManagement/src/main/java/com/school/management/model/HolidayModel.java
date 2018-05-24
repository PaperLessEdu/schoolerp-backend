package com.school.management.model;

import java.time.LocalDateTime;

import com.school.management.domain.Holiday;

public class HolidayModel {

	private Long holiday_id;

	private String name;

	private LocalDateTime date;

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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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
		this.discription = holiday.getDiscripation();
		this.date = holiday.getDate();

	}

}