package com.school.management.model;

import com.school.management.domain.Student;

public class StudentModel {

	private String academicYear;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String dob;
	
	private String gender;
	
	private String bloodGroup;
	
	private String category;
	
	private String caste;
	
	private String religion;
	
	private String standard;
	
	private String division;
	
	private String nationality;
	
	private String permanentAddress;
	
	private String correspondenceAddress;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String postalCode;
	
	private ParentModel fathersDetails;
	
	private ParentModel mothersDetails;
	
	private ParentModel guardianDetails;

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public ParentModel getFathersDetails() {
		return fathersDetails;
	}

	public void setFathersDetails(ParentModel fathersDetails) {
		this.fathersDetails = fathersDetails;
	}

	public ParentModel getMothersDetails() {
		return mothersDetails;
	}

	public void setMothersDetails(ParentModel mothersDetails) {
		this.mothersDetails = mothersDetails;
	}

	public ParentModel getGuardianDetails() {
		return guardianDetails;
	}

	public void setGuardianDetails(ParentModel guardianDetails) {
		this.guardianDetails = guardianDetails;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void wrapDetails(Student student) {
		this.academicYear = student.getAcademicYear();
		
		this.firstName = student.getFirstName();
		
		this.middleName = student.getMiddleName();
		
		this.lastName = student.getLastName();
		
		this.dob = student.getDob();
		
		this.gender = student.getGender();
		
		this.bloodGroup = student.getBloodGroup();
		
		this.category = student.getCategory();
		
		this.caste = student.getCaste();
		
		this.religion = student.getReligion();
		
		this.standard = student.getStandard();
		
		this.division = student.getDivision();
		
		this.nationality = student.getNationality();
		
		this.permanentAddress = student.getPermanentAddress();
		
		this.correspondenceAddress = student.getCorrespondenceAddress();
		
		this.country = student.getCountry();
		
		this.state = student.getState();
		
		this.city = student.getCity();
		
		this.postalCode = student.getPostalCode();
		
		ParentModel fatherParentModel = new ParentModel();
		fatherParentModel.wrapDetails(student.getFather());
		this.fathersDetails = fatherParentModel;
		
		ParentModel motherParentModel = new ParentModel();
		motherParentModel.wrapDetails(student.getMother());
		this.mothersDetails = motherParentModel;
		
		ParentModel guardianParentModel = new ParentModel();
		guardianParentModel.wrapDetails(student.getGuardian());
		this.guardianDetails = guardianParentModel;
	}
}
