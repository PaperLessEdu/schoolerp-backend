package com.school.management.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "standard")
public class Standard {

	public Standard() {
		
	}
	
	public Standard(long standard_id, String name, List<Division> divisions) {
		super();
		this.standard_id = standard_id;
		this.name = name;
		this.division = divisions;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long standard_id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="standard", cascade = CascadeType.ALL, targetEntity = Division.class)
	@JsonManagedReference
	private List<Division> division;
	
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
	
	public List<Division> getDivision() {
		return division;
	}

	public void setDivision(List<Division> division) {
		this.division = division;
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
