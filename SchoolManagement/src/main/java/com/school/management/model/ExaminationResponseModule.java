package com.school.management.model;

import java.util.List;

public class ExaminationResponseModule {

	private String name;

	private List<ExamScheduleResponseModel> examSchedule;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExamScheduleResponseModel> getExamSchedule() {
		return examSchedule;
	}

	public void setExamSchedule(List<ExamScheduleResponseModel> examSchedule) {
		this.examSchedule = examSchedule;
	}

	@Override
	public String toString() {
		return "ExaminationResponseModule [name=" + name + ", examSchedule=" + examSchedule + "]";
	}

}
