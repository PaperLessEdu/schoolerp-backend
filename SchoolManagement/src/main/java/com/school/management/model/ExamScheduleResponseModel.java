package com.school.management.model;

import java.util.List;

/**
 * 
 * @author Pavan.Pawar
 *
 */
public class ExamScheduleResponseModel {

	private Long subjectId;
	private List<ExamDistributionResponse> distribution;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public List<ExamDistributionResponse> getDistribution() {
		return distribution;
	}

	public void setDistribution(List<ExamDistributionResponse> distribution) {
		this.distribution = distribution;
	}

	@Override
	public String toString() {
		return "ExamScheduleResponseModel [subjectId=" + subjectId + ", distribution=" + distribution + "]";
	}

}
