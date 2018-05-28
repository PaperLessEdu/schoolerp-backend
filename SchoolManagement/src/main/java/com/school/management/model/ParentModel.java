package com.school.management.model;

import com.school.management.domain.Parent;

public class ParentModel {
	
	private String name;
	
	private String occupation;
	
	private String qualification;
	
	private String phoneNumber;
	
	private String emailId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void wrapDetails(Parent parent) {
		this.name = parent.getName();
		this.occupation = parent.getOccupation();
		this.qualification = parent.getQualification();
		this.phoneNumber = parent.getPhoneNumber();
		this.emailId = parent.getEmailId();
	}
}
