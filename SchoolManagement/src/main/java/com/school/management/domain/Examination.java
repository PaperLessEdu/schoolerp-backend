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
	@Column(name = "exam_master_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long exammasterid;

	@ManyToOne(targetEntity = AcademicYear.class)
	@JoinColumn(name = "academicYearId", referencedColumnName = "id")
	private AcademicYear academicyear;

	@ManyToOne(targetEntity = Standard.class)
	@JoinColumn(name = "standard_id", referencedColumnName = "standard_id")
	private Standard standard;

	@Column(name = "name")
	private String name;

	public long getExammasterid() {
		return exammasterid;
	}

	public void setExammasterid(long exammasterid) {
		this.exammasterid = exammasterid;
	}

	public AcademicYear getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(AcademicYear academicyear) {
		this.academicyear = academicyear;
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

	@Override
	public String toString() {
		return "Examination [exammasterid=" + exammasterid + ", academicyear=" + academicyear + ", standard=" + standard
				+ ", name=" + name + "]";
	}

}

