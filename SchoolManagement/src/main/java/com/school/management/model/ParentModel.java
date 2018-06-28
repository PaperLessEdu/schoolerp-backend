package com.school.management.model;

import com.school.management.domain.Parent;

public class ParentModel {
	
	private String name;
	
	private String occupation;
	
	private String qualification;
	
	private String phoneNumber;
	
	private String emailId;
	
	private String birthdate;
	
	private String monthlyIncome;
	
	private String relationship;

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
	
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public void wrapDetails(Parent parent) {
		this.name = parent.getName();
		this.occupation = parent.getOccupation();
		this.qualification = parent.getQualification();
		this.phoneNumber = parent.getPhoneNumber();
		this.emailId = parent.getEmailId();
		this.birthdate = parent.getBirthDate();
		this.setMonthlyIncome(parent.getMonthlyIncome());
		this.setRelationship(parent.getRelationship());
	}
}
