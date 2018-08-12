package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Examination;
import com.school.management.domain.ScheduleExam;
import com.school.management.domain.Subject;

public interface ScheduleExamDao {

	public ScheduleExam saveScheduleExam(ScheduleExam scheduleExam);

	public List<ScheduleExam> getAllSchedule();

	public List<ScheduleExam> getScheduleByExamId(Examination examID);

	public List<ScheduleExam> getScheduleByExamIdSubjectId(Examination examID, Subject subjectID);

}
