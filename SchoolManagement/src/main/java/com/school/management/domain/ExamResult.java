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

	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Student student_id;

	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;

	@Column(name = "exam_type")
	private String examType;

	@Column(name = "score_type")
	private String scoreType;

	@Column(name = "mark")
	private Long mark;

	@Column(name = "grade")
	private String grade;

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

	public Student getStudent() {
		return student_id;
	}

	public void setStudent(Student student_id) {
		this.student_id = student_id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

	public Long getMark() {
		return mark;
	}

	public void setMark(Long mark) {
		this.mark = mark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
				+ ", scheduleExam=" + scheduleExam + ", student_id=" + student_id + ", subject=" + subject + ", examtype="
				+ examType + ", scoreType =" + scoreType + ", mark=" + mark + ", grade=" + grade + ", create_dt=" + create_dt
				+ ", last_update_dt=" + last_update_dt + "]";
	}

}