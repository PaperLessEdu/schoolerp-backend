package com.school.management.model;

import java.util.Date;

public class DistributionModel {
	/**
	 * "examType": "Theory", "date": "", "startTime": "", "endTime": "",
	 * "scoreType": "Marks", "outOfMarks": 50, "passingMarks": 35
	 */

	private String examType;
	private Date date;
	private Date startTime;
	private Date endTime;
	private String scoreType;
	private long outOfMarks;
	private long passingMarks;

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public long getOutOfMarks() {
		return outOfMarks;
	}

	public void setOutOfMarks(long outOfMarks) {
		this.outOfMarks = outOfMarks;
	}

	public long getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(long passingMarks) {
		this.passingMarks = passingMarks;
	}

	@Override
	public String toString() {
		return "DistributionModel [examType=" + examType + ", date=" + date + ", startTime=" + startTime + ", endTime="
				+ endTime + ", scoreType=" + scoreType + ", outOfMarks=" + outOfMarks + ", passingMarks=" + passingMarks
				+ "]";
	}

}
