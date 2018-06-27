package com.school.management.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")

public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long attendance_id;

	@ManyToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Student student;

	@ManyToOne(targetEntity = Standard.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "standard_id", referencedColumnName = "standard_id")
	private Standard standard;

	@ManyToOne(targetEntity = Division.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "division_id", referencedColumnName = "division_id")
	private Division division;

	@Column(name = "is_present")
	private String isPresent;

	@Column(name = "date")
	private Date date;


	public long getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(long attendance_id) {
		this.attendance_id = attendance_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public String getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(String isPresent) {
		this.isPresent = isPresent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



}
