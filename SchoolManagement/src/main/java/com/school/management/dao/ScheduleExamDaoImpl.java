package com.school.management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Examination;
import com.school.management.domain.ScheduleExam;
import com.school.management.domain.Subject;
import com.school.management.repository.ScheduleExamRepository;

/**
 * 
 * @author Pavan.Pawar
 *
 */
@Component
public class ScheduleExamDaoImpl implements ScheduleExamDao {

	@Autowired
	private ScheduleExamRepository scheduleExamRepository;

	@Override
	public ScheduleExam saveScheduleExam(ScheduleExam scheduleExam) {
		return scheduleExamRepository.save(scheduleExam);
	}

	@Override
	public List<ScheduleExam> getAllSchedule() {

		return scheduleExamRepository.findAll();
	}

	@Override
	public List<ScheduleExam> getScheduleByExamId(Examination examID) {

		return scheduleExamRepository.getScheduleByExamId(examID);
	}

	@Override
	public List<ScheduleExam> getScheduleByExamIdSubjectId(Examination examID, Subject subjectID) {

		return scheduleExamRepository.getScheduleByExamIdSubjectID(examID, subjectID);
	}

}
