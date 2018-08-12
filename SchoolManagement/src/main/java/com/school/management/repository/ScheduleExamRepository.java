package com.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.management.domain.Examination;
import com.school.management.domain.ScheduleExam;
import com.school.management.domain.Subject;

/**
 * 
 * @author Pavan.Pawar
 *
 */
public interface ScheduleExamRepository extends JpaRepository<ScheduleExam, Long> {

	@Query("SELECT p FROM ScheduleExam p WHERE exam_master_id =:exam_master_id ")
	public List<ScheduleExam> getScheduleByExamId(@Param("exam_master_id") Examination exam_master_id);

	@Query("SELECT p FROM ScheduleExam p WHERE exam_master_id =:exam_master_id and subject_id =:subject_id")
	public List<ScheduleExam> getScheduleByExamIdSubjectID(@Param("exam_master_id") Examination exam_master_id,
			@Param("subject_id") Subject subject_id);

}
