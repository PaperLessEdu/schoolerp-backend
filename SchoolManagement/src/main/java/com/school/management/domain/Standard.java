package com.school.management.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table (name = "standard")
public class Standard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long standard_id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "create_dt", updatable = false)
	@CreationTimestamp
	private LocalDateTime create_dt;
	
	@Column(name = "last_update_dt")
	@UpdateTimestamp
	private LocalDateTime last_update_dt;

	public long getStandard_id() {
		return standard_id;
	}

	public void setStandard_id(long standard_id) {
		this.standard_id = standard_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getCreate_dt() {
		return create_dt;
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
}
