package com.school.management.model;

import com.school.management.domain.Employee;

public class AddToEmployeeRequest {
	
	private Long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String nationality;
	
	private String gender;
	
	private String dob;
	
	private String bloodGroup;
	
	private String maritalStatus;
	
	private String qualification;
	
	private String occupation;
	
	private String jobType;
	
	private String employeeType;
	
	private String dateOfJoining;
	
	private String aadharCardNumber;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String alternatePhoneNumber;
	
	private String permanentAddress;
	
	private String correspondenceAddress;
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	private long roleId;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	public void wrapDetails(Employee employee) {
		this.id = employee.getId();
		this.firstName = employee.getFirstName();
		this.middleName = employee.getMiddleName();
		this.lastName = employee.getLastName();
		this.nationality = employee.getNationality();
		this.gender = employee.getGender();
		this.dob = employee.getDob();
		this.aadharCardNumber = employee.getAadharCardNumber();
		this.alternatePhoneNumber = employee.getAlternatePhoneNumber();
		this.bloodGroup = employee.getBloodGroup();
		this.city = employee.getCity();
		this.correspondenceAddress = employee.getCorrespondenceAddress();
		this.dateOfJoining = this.getDateOfJoining();
		this.emailId = employee.getEmailId();
		this.state = employee.getState();
		this.maritalStatus = employee.getMaritalStatus();
		this.jobType = employee.getJobType();
		this.occupation = employee.getOccupation();
		this.permanentAddress = employee.getPermanentAddress();
		this.phoneNumber = employee.getPhoneNumber();
		this.qualification = employee.getQualification();
		this.roleId = employee.getUserRole().getId();
		this.employeeType = employee.getEmployeeType();
		this.dateOfJoining = employee.getDateOfJoining();
		this.postalCode = employee.getPostalCode();
	}
	
}

