package com.school.management.model;

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

	private Long standardId;
	private Long exam_master_id;
	private Long exam_timetable_id;
	private String score;

	public Long getStandardId() {
		return standardId;
	}

	public void setStandardId(Long standardId) {
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

	@Override
	public String toString() {
		return "ExamResultModel [standardId=" + standardId + ", exam_master_id=" + exam_master_id
				+ ", exam_timetable_id=" + exam_timetable_id + ", score=" + score + "]";
	}

}
