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

	private Standard standard_id;
	private Long exam_master_id;
	private Long exam_timetable_id;
	private Student exam_studentId;

	private Subject exam_subjectId;
	private String examType;
	private String scoreType;
	private Long marks;
	private Long outOfMark;
	private String grade;
	private ArrayList<Long> studentIds;

	
	public Standard getStandard_id() {
		return standard_id;
	}

	public void setStandard_id(Standard standard_id) {
		this.standard_id = standard_id;
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
	

	public Long getOutOfMark() {
		return outOfMark;
	}

	public void setOutOfMark(Long outOfMark) {
		this.outOfMark = outOfMark;
	}

	@Override
	public String toString() {
		return "ExamResultModel [standard_id=" + standard_id + ", exam_master_id=" + exam_master_id
				+ ", exam_timetable_id=" + exam_timetable_id + ", exam_studentId=" + exam_studentId
				+ ", exam_subjectId=" + exam_subjectId + ", examType=" + examType + ", scoreType=" + scoreType
				+ ", marks=" + marks + ", outOfMark=" + outOfMark + ", grade=" + grade + ", studentIds=" + studentIds
				+ "]";
	}

	

	


}
