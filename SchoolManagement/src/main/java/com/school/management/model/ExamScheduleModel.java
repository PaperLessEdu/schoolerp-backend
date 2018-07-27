package com.school.management.model;

import java.util.ArrayList;

public class ExamScheduleModel {
	private long subjectId;

	private ArrayList<DistributionModel> distribution;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public ArrayList<DistributionModel> getDistribution() {
		return distribution;
	}

	public void setDistribution(ArrayList<DistributionModel> distribution) {
		this.distribution = distribution;
	}

	@Override
	public String toString() {
		return "ExamScheduleModel [subjectId=" + subjectId + ", distribution=" + distribution + "]";
	}

}
