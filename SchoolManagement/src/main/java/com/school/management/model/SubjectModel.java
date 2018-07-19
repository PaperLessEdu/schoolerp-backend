package com.school.management.model;

import com.school.management.domain.Subject;

public class SubjectModel {
	
	private Long subject_id;
	
	private String name;

	public Long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void wrapDetails(Subject subject) {
		this.subject_id = subject.getSubject_id();
		this.name = subject.getName();
	}
	
}
