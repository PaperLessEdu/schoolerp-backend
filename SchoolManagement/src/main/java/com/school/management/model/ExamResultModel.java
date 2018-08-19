package com.school.management.model;

import java.time.LocalDateTime;

import com.school.management.domain.Standard;

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
	private String score;
	private LocalDateTime create_dt;

	private LocalDateTime last_update_dt;

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
		return "ExamResultModel [standardId=" + standardId + ", exam_master_id=" + exam_master_id
				+ ", exam_timetable_id=" + exam_timetable_id + ", score=" + score + ", create_dt=" + create_dt
				+ ", last_update_dt=" + last_update_dt + "]";
	}

}
