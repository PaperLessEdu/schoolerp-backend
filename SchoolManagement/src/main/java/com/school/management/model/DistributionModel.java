package com.school.management.model;

import java.util.Date;

public class DistributionModel {
	/**
	 * "examType": "Theory", "date": "", "startTime": "", "endTime": "",
	 * "scoreType": "Marks", "outOfMarks": 50, "passingMarks": 35
	 */

	private String examType;
	private String date;
	private String startTime;
	private String endTime;
	private String scoreType;
	private long outOfMarks;
	private long passingMarks;

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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
