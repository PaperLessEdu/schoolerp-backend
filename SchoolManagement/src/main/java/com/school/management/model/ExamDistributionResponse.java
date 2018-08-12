package com.school.management.model;

import java.util.Date;

public class ExamDistributionResponse {

	private Date date;

	private String startTime;

	private String endTime;

	private String examType;

	private String scoreType;

	private Long marksOutOf;

	private Long passingMarks;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public Long getMarksOutOf() {
		return marksOutOf;
	}

	public void setMarksOutOf(Long marksOutOf) {
		this.marksOutOf = marksOutOf;
	}

	public Long getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(Long passingMarks) {
		this.passingMarks = passingMarks;
	}

	@Override
	public String toString() {
		return "ExamDistributionResponse [date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", examType=" + examType + ", scoreType=" + scoreType + ", marksOutOf=" + marksOutOf
				+ ", passingMarks=" + passingMarks + "]";
	}

}
