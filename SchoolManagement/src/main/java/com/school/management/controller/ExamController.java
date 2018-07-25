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

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.core.CustomException;
import com.school.management.domain.Examination;
import com.school.management.model.ExaminationModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.ExaminationService;

@RestController
@RequestMapping(value = UriConstants.EXAMINATION)
// @CrossOrigin(origins = { "http://dev.cloudscripts.co.in:8082",
// "http://dev.cloudscripts.co.in:8081",
// "http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class ExamController {

	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	@Autowired
	private ExaminationService examinationService;

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addExamination(@RequestBody ExaminationModel examinationModel) {

		SmResponseStatus smResponseStatus = null;
		if (examinationModel.getExam_master_id() == null) {
			String error = String.format("Examination can not be empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = examinationService.addExamination(examinationModel);

		logger.info("Examination Sucessfully added ", examinationModel.getExam_master_id());

		return smResponseStatus;

	}

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Examination> getExaminationList() {

		logger.info("Request received to fetch Exam List");

		List<Examination> examinationList = new ArrayList<>();

		examinationList = examinationService.getExaminationList();

		logger.info("Examination List fetched successfully");

		return examinationList;

	}
}