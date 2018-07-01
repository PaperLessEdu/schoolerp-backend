package com.school.management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long student_id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "bloodGroup")
	private String bloodGroup;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "caste")
	private String caste;
	
	@Column(name = "religion")
	private String religion;
	
	@ManyToOne(targetEntity = Standard.class)
	@JoinColumn(name="standard_id",referencedColumnName="standard_id")
	private Standard standard;
	
	@ManyToOne(targetEntity = Division.class)
	@JoinColumn(name="division_id",referencedColumnName="division_id")
	private Division division;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "permanentAddress")
	private String permanentAddress;
	
	@Column(name = "correspondenceAddress")
	private String correspondenceAddress;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "roll_No")
	private long rollNo;
	
	@Column(name = "doctor_name")
	private String doctorName;
	
	@Column(name = "doctor_phone_number")
	private String doctorPhoneNo;
	
	@Column(name = "doctor_address")
	private String doctorAddress;
	
	@OneToOne(targetEntity = Parent.class)
	@JoinColumn(name = "fatherId", referencedColumnName = "parent_id")
	private Parent father;
	
	@OneToOne(targetEntity = Parent.class)
	@JoinColumn(name = "motherId", referencedColumnName = "parent_id")
	private Parent mother;
	
	@OneToOne(targetEntity = Parent.class)
	@JoinColumn(name = "guardianId", referencedColumnName = "parent_id")
	private Parent guardian;
	
	@Column(name = "admissionDate")
	private String admissionDate;
	
	@OneToOne(targetEntity = AcademicYear.class)
	@JoinColumn(name = "academicYearId", referencedColumnName = "id")
	private AcademicYear academicYear;
	
	@Column(name = "schoolType")
	private String schoolType;
	
	@Column(name = "previousSchoolName")
	private String previousSchoolName;
	
	@Column(name = "birthPlace")
	private String birthPlace;
	
	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
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

	public Parent getFather() {
		return father;
	}

	public void setFather(Parent father) {
		this.father = father;
	}

	public Parent getMother() {
		return mother;
	}

	public void setMother(Parent mother) {
		this.mother = mother;
	}

	public Parent getGuardian() {
		return guardian;
	}

	public void setGuardian(Parent guardian) {
		this.guardian = guardian;
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

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
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
	
}
