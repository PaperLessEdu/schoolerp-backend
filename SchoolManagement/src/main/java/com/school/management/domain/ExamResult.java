package com.school.management.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * 
 * @author Pavan.Pawar
 *
 */
@Entity
@Table(name = "exam_result")
public class ExamResult {
	/*
	 * exam_result_id Primary key standardId Foreign key of standard table
	 * exam_master_id Foreign key of exam_master table exam_timetable_id Foreign
	 * key of exam_timetable_id score
	 */

	@Id
	@Column(name = "exam_result_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long examResultId;

	@ManyToOne(targetEntity = Standard.class)
	@JoinColumn(name = "standard_id", referencedColumnName = "standard_id")
	private Standard standard;

	@ManyToOne(targetEntity = Examination.class)
	@JoinColumn(name = "exam_master_id", referencedColumnName = "exam_master_id")
	private Examination examination;

	@ManyToOne(targetEntity = ScheduleExam.class)
	@JoinColumn(name = "exam_timetable_id", referencedColumnName = "exam_timetable_id")
	private ScheduleExam scheduleExam;

	@Column(name = "score")
	private String score;

	@Column(name = "create_dt", updatable = false)
	@CreationTimestamp
	private LocalDateTime create_dt;

	@Column(name = "last_update_dt")
	@UpdateTimestamp
	private LocalDateTime last_update_dt;

	public long getExamResultId() {
		return examResultId;
	}

	public void setExamResultId(long examResultId) {
		this.examResultId = examResultId;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public ScheduleExam getScheduleExam() {
		return scheduleExam;
	}

	public void setScheduleExam(ScheduleExam scheduleExam) {
		this.scheduleExam = scheduleExam;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public LocalDateTime getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(LocalDateTime create_dt) {
		this.create_dt = create_dt;
	}

	public LocalDateTime getLast_update_dt() {
		return last_update_dt;
	}

	public void setLast_update_dt(LocalDateTime last_update_dt) {
		this.last_update_dt = last_update_dt;
	}

	@Override
	public String toString() {
		return "ExamResult [examResultId=" + examResultId + ", standard=" + standard + ", examination=" + examination
				+ ", scheduleExam=" + scheduleExam + ", score=" + score + ", create_dt=" + create_dt
				+ ", last_update_dt=" + last_update_dt + "]";
	}

	
}
