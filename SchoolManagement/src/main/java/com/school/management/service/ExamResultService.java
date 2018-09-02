package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.ExamResultDaoImpl;
import com.school.management.dao.StudentDaoImpl;
import com.school.management.domain.ExamResult;
import com.school.management.model.ExamResultModel;
import com.school.management.model.SmResponseStatus;

@Service
public class ExamResultService {

	@Autowired
	private ExamResultDaoImpl examResultDaoImpl;
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	

	public static final Logger logger = LoggerFactory.getLogger(ExamResultService.class);

	public SmResponseStatus addExaminationResult(ExamResultModel examResultModel) {

		String message = null;
		Boolean isExamResultExist = null;

		ExamResult examResult = wrapExamResult(null, examResultModel);
		isExamResultExist = examResultDaoImpl.existsById(examResultModel.getExam_master_id());
		
		List<ExamResult> ExamResultFinal = new ArrayList<>();

		for (Long student : examResultModel.getStudentIds()) {
			ExamResult exam = new ExamResult();
			
			exam.setStudent(studentDaoImpl.getStudent(student));
			
			/*

			att.setDivision(divisionDapImpl.getDivision(attendanceModel.getDivision()));
			att.setStandard(standardDaoImpl.getStandard(attendanceModel.getStandard()));

			att.setDate(attendanceModel.getDate());

			att.setIsPresent("false");
			lsAttendance.add(att);
		}
		logger.info(lsAttendance.toString());
*/
				
		

		logger.info("Is ExamResult exist: [{}]", isExamResultExist);
		if (isExamResultExist.equals(Boolean.FALSE)) {
			examResultDaoImpl.saveExamination(examResult);
		} else {

			String error = String.format("Examination Result is already exist with name [%s]",examResultModel.getExam_master_id());
			logger.error(error);
			throw new CustomException(error);
		}

		logger.info("Examination Result saved Sucessfully with name [{}]", examResult.getExamResultId());

		message = String.format("Examination Result saved Sucessfully with name [%s]", examResult.getExamResultId());

		return new SmResponseStatus(message);
	}

	private ExamResult wrapExamResult(Long exam_result_id, ExamResultModel examResultModel) {

		ExamResult examResult = new ExamResult();

		if (exam_result_id != null) {
			examResult.setExamResultId(examResultModel.getExam_master_id());
		}

		examResult.setStandard(examResultModel.getStandardId());
		
		examResult.setStudent(examResultModel.getExam_studentId());
		examResult.setStandard(examResultModel.getStandardId());
		examResult.setSubject(examResultModel.getExam_subjectId());
		examResult.setExamType(examResultModel.getExamType());
		examResult.setScoreType(examResultModel.getScoreType());
		examResult.setMark(examResultModel.getMarks());
		examResult.setGrade(examResultModel.getGrade());
		examResult.setCreate_dt(examResultModel.getCreate_dt());
		examResult.setLast_update_dt(examResultModel.getLast_update_dt());

		return examResult;
	}
}
