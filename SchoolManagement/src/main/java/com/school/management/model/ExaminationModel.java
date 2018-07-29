package com.school.management.model;

import java.util.ArrayList;

public class ExaminationModel {

	private long exam_master_id;
	private long academicYearId;
	private long standardId;
	private String name;
	private ArrayList<ExamScheduleModel> examSchedule;

	public long getAcademicYearId() {
		return academicYearId;
	}

	public void setAcademicYearId(long academicYearId) {
		this.academicYearId = academicYearId;
	}

	public long getStandardId() {
		return standardId;
	}

	public void setStandardId(long standardId) {
		this.standardId = standardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ExamScheduleModel> getExamSchedule() {
		return examSchedule;
	}

	public void setExamSchedule(ArrayList<ExamScheduleModel> examSchedule) {
		this.examSchedule = examSchedule;
	}

	
	
	
	public long getExam_master_id() {
		return exam_master_id;
	}

	public void setExam_master_id(long exam_master_id) {
		this.exam_master_id = exam_master_id;
	}

	@Override
	public String toString() {
		return "ExaminationModel [exam_master_id=" + exam_master_id + ", academicYearId=" + academicYearId
				+ ", standardId=" + standardId + ", name=" + name + ", examSchedule=" + examSchedule + "]";
	}

	/*
	 * public void wrapExamination(Examination examination) {
	 * this.exam_master_id = examination.getExammasterid(); this.academicYearId
	 * = examination.getAcademicyear(); this.standard =
	 * examination.getStandard(); this.name= examination.getName();
	 * 
	 * }
	 */
}
