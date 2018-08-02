package com.school.management.model;

import com.school.management.domain.Student;

public class StudentModel {
	
	private long id;

	private long academicYear;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String dob;
	
	private String gender;
	
	private String bloodGroup;
	
	private String category;
	
	private String caste;
	
	private String religion;
	
	private long standard;
	
	private long division;
	
	private String nationality;
	
	private String permanentAddress;
	
	private String correspondenceAddress;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String postalCode;
	
	private long rollNo;
	
	private String doctorName;
	
	private String doctorPhoneNo;
	
	private String doctorAddress;
	
	private ParentModel fathersDetails;
	
	private ParentModel mothersDetails;
	
	private ParentModel guardianDetails;
		
	private String admissionDate;
	
	private String schoolType;
	
	private String previousSchoolName;
	
	private String birthPlace;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(long academicYear) {
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
	
	public long getStandard() {
		return standard;
	}

	public void setStandard(long standard) {
		this.standard = standard;
	}

	public long getDivision() {
		return division;
	}

	public void setDivision(long division) {
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

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorPhoneNo() {
		return doctorPhoneNo;
	}

	public void setDoctorPhoneNo(String doctorPhoneNo) {
		this.doctorPhoneNo = doctorPhoneNo;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getPreviousSchoolName() {
		return previousSchoolName;
	}

	public void setPreviousSchoolName(String previousSchoolName) {
		this.previousSchoolName = previousSchoolName;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public void wrapDetails(Student student) {
		
		this.id = student.getStudent_id();
		
		if(student.getAcademicYear() != null) {
			this.academicYear = Long.valueOf(student.getAcademicYear().getAcademicYearId()) != null ?student.getAcademicYear().getAcademicYearId() : null;
		}
		
		this.firstName = student.getFirstName();
		
		this.middleName = student.getMiddleName();
		
		this.lastName = student.getLastName();
		
		this.dob = student.getDob();
		
		this.gender = student.getGender();
		
		this.bloodGroup = student.getBloodGroup();
		
		this.category = student.getCategory();
		
		this.caste = student.getCaste();
		
		this.religion = student.getReligion();
		
		this.standard = student.getStandard().getStandard_id();
		
		this.division = student.getDivision().getDivision_id();
		
		this.nationality = student.getNationality();
		
		this.permanentAddress = student.getPermanentAddress();
		
		this.correspondenceAddress = student.getCorrespondenceAddress();
		
		this.country = student.getCountry();
		
		this.state = student.getState();
		
		this.city = student.getCity();
		
		this.postalCode = student.getPostalCode();
		
		this.rollNo = Long.valueOf(student.getRollNo()) != null ? student.getRollNo(): null;
		
		this.doctorName = student.getDoctorName() != null ? student.getDoctorName(): "";
		
		this.doctorPhoneNo = student.getDoctorPhoneNo() != null ? student.getDoctorPhoneNo(): "";
		
		this.doctorAddress = student.getDoctorAddress() != null ? student.getDoctorAddress(): "";
		
		this.admissionDate = student.getAdmissionDate() !=null ? student.getAdmissionDate() : "";
		
		this.schoolType = student.getSchoolType() != null ? student.getSchoolType(): "";
		
		this.previousSchoolName = student.getPreviousSchoolName() != null ? student.getPreviousSchoolName():"";
		
		this.birthPlace = student.getBirthPlace() !=null ? student.getBirthPlace() : "";
		
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
