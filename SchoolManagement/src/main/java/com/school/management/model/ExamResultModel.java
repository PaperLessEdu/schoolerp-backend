package com.school.management.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.school.management.domain.Standard;
import com.school.management.domain.Student;
import com.school.management.domain.Subject;

/**
 * 
 * @author Pavan.Pawar
 *
 */
public class ExamResultModel {

	/**
	 * exam_result_id Primary key standardId Foreign key of standard table
	 * exam_master_id Foreign key of exam_master table exam_timetable_id Foreign
	 * key of exam_timetable_id score
	 */

	private Standard standardId;
	private Long exam_master_id;
	private Long exam_timetable_id;
	private Student exam_studentId;

	private Subject exam_subjectId;
	private String examType;
	private String scoreType;
	private Long marks;
	private String grade;
	private LocalDateTime create_dt;

	private LocalDateTime last_update_dt;
	private ArrayList<Long> studentIds;

	public Standard getStandardId() {
		return standardId;
	}

	public void setStandardId(Standard standardId) {
		this.standardId = standardId;
	}

	public Long getExam_master_id() {
		return exam_master_id;
	}

	public void setExam_master_id(Long exam_master_id) {
		this.exam_master_id = exam_master_id;
	}

	public Long getExam_timetable_id() {
		return exam_timetable_id;
	}

	public void setExam_timetable_id(Long exam_timetable_id) {
		this.exam_timetable_id = exam_timetable_id;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
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

	public Student getExam_studentId() {
		return exam_studentId;
	}

	public void setExam_studentId(Student exam_studentId) {
		this.exam_studentId = exam_studentId;
	}

	public Subject getExam_subjectId() {
		return exam_subjectId;
	}

	public void setExam_subjectId(Subject exam_subjectId) {
		this.exam_subjectId = exam_subjectId;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public Long getMarks() {
		return marks;
	}

	public void setMarks(Long marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	public ArrayList<Long> getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(ArrayList<Long> studentIds) {
		this.studentIds = studentIds;
	}

	@Override
	public String toString() {
		return "ExamResultModel [standardId=" + standardId + ", exam_master_id=" + exam_master_id
				+ ", exam_timetable_id=" + exam_timetable_id + ", exam_studentId=" + exam_studentId
				+ ", exam_subjectId=" + exam_subjectId + ", examType=" + examType + ", score=" + scoreType + ", marks="
				+ marks + ", grade=" + grade + ", create_dt=" + create_dt + ", last_update_dt=" + last_update_dt + "]";
	}

}
