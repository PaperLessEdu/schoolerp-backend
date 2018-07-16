package com.school.management.domain;

import java.time.LocalDateTime;
import java.util.Date;

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

@Entity
@Table (name = "exam_timetable")
public class ScheduleExam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long exam_timetable_id;
	
	@ManyToOne(targetEntity = Examination.class)
	@JoinColumn(name="exam_master_id",referencedColumnName="exam_master_id")
	private Examination exam_master_id;
	
	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name="subject_id",referencedColumnName="subject_id")
	private Subject subject_id;
	
	@ManyToOne(targetEntity = Standard.class)
	@JoinColumn(name="standard_id",referencedColumnName="standard_id")
	private Standard standard;
	
	@Column(name = "examType")
	private String examType;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "create_dt", updatable = false)
	@CreationTimestamp
	private LocalDateTime create_dt;
	
	@Column(name = "last_update_dt")
	@UpdateTimestamp
	private LocalDateTime last_update_dt;

	@Column(name = "outOfMarks")
	private Double outOfMarks;
	
	@Column(name = "passingMarks")
	private Double passingMarks;
	
	

	public long getExam_timetable_id() {
		return exam_timetable_id;
	}

	public void setExam_timetable_id(long exam_timetable_id) {
		this.exam_timetable_id = exam_timetable_id;
	}

	public Examination getExam_master_id() {
		return exam_master_id;
	}

	public void setExam_master_id(Examination exam_master_id) {
		this.exam_master_id = exam_master_id;
	}

	public Subject getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Subject subject_id) {
		this.subject_id = subject_id;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

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

	public Double getOutOfMarks() {
		return outOfMarks;
	}

	public void setOutOfMarks(Double outOfMarks) {
		this.outOfMarks = outOfMarks;
	}

	public Double getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(Double passingMarks) {
		this.passingMarks = passingMarks;
	}
	
	
}
