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
import com.school.management.model.ExaminationModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.ExaminationService;

@RestController
@RequestMapping(value = UriConstants.EXAMINATION)
@CrossOrigin(origins = { "http://dev.cloudscripts.co.in:8082", "http://dev.cloudscripts.co.in:8081",
		"http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class ExamController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addExamination(@RequestBody ExaminationService examinationservice) {
	
	/*@Autowired
	private ExaminationModel examinationModel; 
	
		SmResponseStatus smResponseStatus = null;
		if (examinationModel.getExam_master_id() == null) {
			String error = String.format("Examination can not be empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = examinationservice.addExamination(examinationModel);

		//logger.info("Examination Sucessfully added ",examinationModel.getExam_master_id(), examinationModel.getAcademicYear());
*/		
	return null; 
		//smResponseStatus;

	}
}