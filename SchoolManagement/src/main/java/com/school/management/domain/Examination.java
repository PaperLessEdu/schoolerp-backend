package com.school.management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_master")
public class Examination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long exam_master_id;

	//@ManyToOne(targetEntity = AcademicYear.class)
	//@JoinColumn(name = "academicYearId", referencedColumnName = "academicYearId")
	//private AcademicYear academicYearId;

	@ManyToOne(targetEntity = Standard.class)
	@JoinColumn(name = "standard_id", referencedColumnName = "standard_id")
	private Standard standard;

	@Column(name = "name")
	private String name;

	public long getExam_master_id() {
		return exam_master_id;
	}

	public void setExam_master_id(long exam_master_id) {
		this.exam_master_id = exam_master_id;
	}

	
	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
