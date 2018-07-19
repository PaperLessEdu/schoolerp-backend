package com.school.management.model;

import com.school.management.domain.AcademicYear;
import com.school.management.domain.Examination;
import com.school.management.domain.Standard;

public class ExaminationModel {

	private Long exam_master_id;

	private AcademicYear academicYearId;

	private Standard standard;

	private String name;

	public Long getExam_master_id() {
		return exam_master_id;
	}

	public void setExam_master_id(Long exam_master_id) {
		this.exam_master_id = exam_master_id;
	}

	public AcademicYear getAcademicYearId() {
		return academicYearId;
	}

	public void setAcademicYearId(AcademicYear academicYearId) {
		this.academicYearId = academicYearId;
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

	public void wrapExamination(Examination examination) {
		this.exam_master_id = examination.getExammasterid();
		this.academicYearId = examination.getAcademicyear();
		this.standard = examination.getStandard();

	}
}
