package com.school.management.model;

import java.time.LocalDateTime;

import com.school.management.domain.Division;

public class DivisionModel {

private Long division_id;
	
	private String name;
	
	private LocalDateTime create_dt;
	
	private LocalDateTime last_update_dt;

	public Long getDivision_id() {
		return division_id;
	}

	public void setDivision_id(Long division_id) {
		this.division_id = division_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setCreate_dt(LocalDateTime create_dt) {
		this.create_dt = create_dt;
	}
	
	public LocalDateTime getLast_update_dt() {
		return last_update_dt;
	}

	public void setLast_update_dt(LocalDateTime last_update_dt) {
		this.last_update_dt = last_update_dt;
	}
	
	public void wrapDetails(Division division) {
		this.division_id = division.getDivision_id();
		this.name = division.getName();
		this.create_dt = division.getCreate_dt();
		this.last_update_dt = division.getLast_update_dt();
	}	
}
