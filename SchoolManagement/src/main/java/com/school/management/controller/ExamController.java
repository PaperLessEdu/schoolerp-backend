package com.school.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.model.ExamResultModel;
import com.school.management.model.ExaminationModel;
import com.school.management.model.ExaminationResponseModule;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.ExaminationService;

/**
 * 
 * @author Pavan.Pawar
 *
 */
@RestController
@RequestMapping(value = UriConstants.EXAMINATION)
@CrossOrigin( origins = {"http://dev.cloudscripts.co.in:8082","http://dev.cloudscripts.co.in:8081", "http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class ExamController {

	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@Autowired
	private ExaminationService examinationService;

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addExamination(@RequestBody ExaminationModel examinationModel) {

		logger.info("Examination model : " + examinationModel.toString());
		SmResponseStatus smResponseStatus = null;
		/*
		 * if (examinationModel.getExam_master_id() == null) { String error =
		 * String.format("Examination can not be empty"); logger.error(error);
		 * throw new CustomException(error); }
		 */
		smResponseStatus = examinationService.addExamination(examinationModel);

		// logger.info("Examination Sucessfully added ",
		// examinationModel.getExam_master_id());

		return smResponseStatus;

	}

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<ExaminationResponseModule> getExaminationList() {

		logger.info("Request received to fetch Exam List");

		List<ExaminationResponseModule> examinationList = new ArrayList<>();

		ExaminationResponseModule e = new ExaminationResponseModule();

		examinationList.add(e);
		examinationList = examinationService.getExaminationList();

		logger.info("Examination List fetched successfully");

		return examinationList;

	}

	@RequestMapping(value = UriConstants.FILLMARKS, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addMarks(@RequestBody ExamResultModel ExamResultModel) {

		logger.info("ExamResultModel model : " + ExamResultModel.toString());
		SmResponseStatus smResponseStatus = null;
		/*
		 * if (examinationModel.getExam_master_id() == null) { String error =
		 * String.format("Examination can not be empty"); logger.error(error);
		 * throw new CustomException(error); }
		 */

		// logger.info("Examination Sucessfully added ",
		// examinationModel.getExam_master_id());

		return smResponseStatus;

	}
}
