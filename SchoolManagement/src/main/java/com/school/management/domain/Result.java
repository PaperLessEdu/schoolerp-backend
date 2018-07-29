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
@Table(name = "exam_result")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long exam_result_id;

	@ManyToOne(targetEntity = Standard.class)
	@JoinColumn(name = "standard_id", referencedColumnName = "standard_id")
	private Standard standard;

	@ManyToOne(targetEntity = Examination.class)
	@JoinColumn(name = "exam_master_id", referencedColumnName = "exam_master_id")
	private Examination exam_master_id;

	@ManyToOne(targetEntity = ScheduleExam.class)
	@JoinColumn(name = "exam_timetable_id", referencedColumnName = "exam_timetable_id")
	private ScheduleExam exam_timetable_id;

	@Column(name = "score")
	private Double score;

	public long getExam_result_id() {
		return exam_result_id;
	}

	public void setExam_result_id(long exam_result_id) {
		this.exam_result_id = exam_result_id;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Examination getExam_master_id() {
		return exam_master_id;
	}

	public void setExam_master_id(Examination exam_master_id) {
		this.exam_master_id = exam_master_id;
	}

	public ScheduleExam getExam_timetable_id() {
		return exam_timetable_id;
	}

	public void setExam_timetable_id(ScheduleExam exam_timetable_id) {
		this.exam_timetable_id = exam_timetable_id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Result [exam_result_id=" + exam_result_id + ", standard=" + standard + ", exam_master_id="
				+ exam_master_id + ", exam_timetable_id=" + exam_timetable_id + ", score=" + score + "]";
	}

}
