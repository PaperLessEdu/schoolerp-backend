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
import com.school.management.model.SmResponseStatus;
import com.school.management.model.StudentModel;
import com.school.management.service.StudentService;

@RestController
@RequestMapping(value =  UriConstants.STUDENT)
@CrossOrigin( origins = {"http://dev.cloudscripts.co.in", "http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired 
	private StudentService studentService;
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addStudent(@RequestBody StudentModel studentModel) {
		
		logger.info("Request received to add student with name [{}], [{}]",studentModel.getFirstName(), studentModel.getGender());
		
		SmResponseStatus smResponseStatus = null;
		if(studentModel.getFirstName() == null || studentModel.getLastName() == null) {
			String error = String.format("Student first name/last name can not be empty");
			logger.error(error);
			new CustomException(error);
		}
		
		smResponseStatus = studentService.addStudent(studentModel);
		
		return smResponseStatus;
		
	}
}
