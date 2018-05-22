package com.school.management.model;

import java.time.LocalDateTime;

import com.school.management.domain.Standard;

public class StandardModel {

	private Long standard_id;
	
	private String name;
	
	private LocalDateTime create_dt;
	
	private LocalDateTime last_update_dt;

	public Long getStandard_id() {
		return standard_id;
	}

	public void setStandard_id(Long standard_id) {
		this.standard_id = standard_id;
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
	
	public void wrapDetails(Standard standard) {
		this.standard_id = standard.getStandard_id();
		this.name = standard.getName();
		this.create_dt = standard.getCreate_dt();
		this.last_update_dt = standard.getLast_update_dt();
	}	
	
}
