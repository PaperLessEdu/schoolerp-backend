package com.school.management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.ScheduleExam;
import com.school.management.repository.ScheduleExamRepository;

@Component
public class ScheduleExamDaoImpl implements ScheduleExamDao {

	@Autowired
	private ScheduleExamRepository scheduleExamRepository;

	@Override
	public void saveScheduleExam(ScheduleExam scheduleExam) {
		scheduleExamRepository.save(scheduleExam);
	}

}
