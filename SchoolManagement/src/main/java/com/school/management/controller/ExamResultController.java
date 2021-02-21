package com.school.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.core.CustomException;
import com.school.management.model.ExamResultModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.ExamResultService;

@RestController
@RequestMapping(value = UriConstants.EXAMINATION_RESULT)
@CrossOrigin(origins = { "http://dev.cloudscripts.co.in:8082", "http://dev.cloudscripts.co.in:8081",
		"http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class ExamResultController {

	private static final Logger logger = LoggerFactory.getLogger(ExamResultController.class);

	@Autowired
	private ExamResultService examResultService;

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addExaminationResult(@RequestBody ExamResultModel examResultModel) {

		logger.info("Examination model : " + examResultModel.toString());
		SmResponseStatus smResponseStatus = null;

		if (examResultModel.getExam_master_id() == null) {
			String error = String.format("Examination Result can not be empty");
			logger.error(error);
			throw new CustomException(error);
		}

		smResponseStatus = examResultService.addExaminationResult(examResultModel);

		logger.info("Examination Result Sucessfully added ", examResultModel.getExam_master_id());

		return smResponseStatus;

	}
}
