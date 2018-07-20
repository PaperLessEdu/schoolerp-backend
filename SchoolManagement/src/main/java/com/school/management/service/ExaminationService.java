package com.school.management.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.ExaminationDaoImpl;
import com.school.management.domain.Examination;
import com.school.management.model.ExaminationModel;
import com.school.management.model.SmResponseStatus;

@Service
public class ExaminationService {

	@Autowired
	private ExaminationDaoImpl examinationDaoImpl;

	public static final Logger logger = LoggerFactory.getLogger(ExaminationService.class);

	public SmResponseStatus addExamination(ExaminationModel examinationModel) {

		String message = null;
		Boolean isExaminationExist = null;

		Examination examination = wrapExmination(null, examinationModel);

		isExaminationExist =examinationDaoImpl.isExistByName(examinationModel.getName());
		
		logger.info("Is Division exist: [{}]",isExaminationExist);
		return new SmResponseStatus(message);
	}

	private Examination wrapExmination(Long exam_master_id, ExaminationModel examinationModel) {

		Examination examination = new Examination();
		if (exam_master_id != null) {

			examination.setExammasterid(examinationModel.getExam_master_id());
		}

		examination.setName(examinationModel.getName());
		return examination;
	}

}
