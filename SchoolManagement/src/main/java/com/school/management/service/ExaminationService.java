package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.ExaminationDaoImpl;
import com.school.management.dao.ScheduleExamDaoImpl;
import com.school.management.domain.AcademicYear;
import com.school.management.domain.Examination;
import com.school.management.domain.ScheduleExam;
import com.school.management.domain.Standard;
import com.school.management.model.ExaminationModel;
import com.school.management.model.SmResponseStatus;

@Service
public class ExaminationService {

	@Autowired
	private ExaminationDaoImpl examinationDaoImpl;

	@Autowired
	private ScheduleExamDaoImpl scheduleExamDaoImpl;
	
	
	public static final Logger logger = LoggerFactory.getLogger(ExaminationService.class);

	public SmResponseStatus addExamination(ExaminationModel examinationModel) {

		String message = null;

		Examination examination = wrapExmination(null, examinationModel);

		// TODO please verify student is present or not before saving same for
		// accadimic year id

		examinationDaoImpl.saveExamination(examination);
		
		ScheduleExam scheduleExam =new ScheduleExam();
		scheduleExam.setDate(null);
		scheduleExam.setExamType("abc");
		scheduleExam.setOutOfMarks(10.00);
		
		scheduleExamDaoImpl.saveScheduleExam(scheduleExam );
		
		
		message = String.format("Examination saved successfully with name [%s]", examination.getName());

		return new SmResponseStatus(message);
	}

	public List<Examination> getExaminationList() {

		List<Examination> examinationList = new ArrayList<>();

		try {
			examinationList = examinationDaoImpl.getExaminationList();

		} catch (Exception e) {
			String error = String.format("Error occured while fetching examination List");
			logger.error(error, e);
			throw e;
		}
		return examinationList;

	}

	private Examination wrapExmination(Long exam_master_id, ExaminationModel examinationModel) {

		Examination examination = new Examination();

		if (exam_master_id != null) {

			examination.setExammasterid(examinationModel.getExam_master_id());

		}
		AcademicYear y = new AcademicYear();
		y.setAcademicYearId(examinationModel.getAcademicYearId());
		examination.setAcademicyear(y);
		examination.setName(examinationModel.getName());
		Standard s = new Standard();
		s.setStandard_id(examinationModel.getStandardId());
		examination.setStandard(s);

		return examination;
	}

}
