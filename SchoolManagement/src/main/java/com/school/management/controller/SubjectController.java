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
import com.school.management.domain.Subject;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.SubjectService;

@RestController
@RequestMapping(value = UriConstants.SUBJECTS)
public class SubjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addSubject(@RequestBody Subject subject) {
		
		logger.info("Request received to add Subject with name [{}]", subject.getName());
		
		SmResponseStatus smResponseStatus = null;;
		if (subject.getName() == null ) {
			String error = String.format("Subject name can not empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = subjectService.addSubject(subject);
		
		logger.info("Subject Sucessfully added with name [{}]", subject.getName());
		return smResponseStatus;
	}
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Subject> getSubjectList() {

		logger.info("Request received to fetch Subject List");
		
		List<Subject> subjectList = new ArrayList<>();

		subjectList = subjectService.getSubjectList();
		
		logger.info("Subject List fetched successfully");
		
		return subjectList;

	}

}
