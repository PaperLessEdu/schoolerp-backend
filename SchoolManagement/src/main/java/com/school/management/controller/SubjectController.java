package com.school.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.core.CustomException;
import com.school.management.domain.Subject;
import com.school.management.model.AddToEmployeeRequest;
import com.school.management.model.SmResponseStatus;
import com.school.management.model.SubjectModel;
import com.school.management.service.SubjectService;

@RestController
@RequestMapping(value = UriConstants.SUBJECTS)
@CrossOrigin(origins = { "http://dev.cloudscripts.co.in", "http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class SubjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addSubject(@RequestBody SubjectModel subjectModel) {
		
		logger.info("Request received to add Subject with name [{}]", subjectModel.getName());
		
		SmResponseStatus smResponseStatus = null;;
		if (subjectModel.getName() == null ) {
			String error = String.format("Subject name can not empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = subjectService.addSubject(subjectModel);
		
		logger.info("Subject Sucessfully added with name [{}]", subjectModel.getName());
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
	
	@RequestMapping(value = UriConstants.SUBJECT_ID, method = RequestMethod.GET, produces = AppConstants.JSON)
	public SubjectModel getSubject(@PathVariable Long subject_id) {

		logger.info("Request received to fetch Subject details by subject_id");
		
		SubjectModel subjectModel = subjectService.getSubject(subject_id);
		
		logger.info("Subject by id [{}] fetched successfully", subject_id);
		
		return subjectModel;
	}
	
	@RequestMapping(value = UriConstants.SUBJECT_ID, method = RequestMethod.PUT, produces = AppConstants.JSON)
	public SmResponseStatus updateSubject(@PathVariable Long subject_id, @RequestBody SubjectModel subjectModel) {

		logger.info("Request received to update Subject with name [{}]",subjectModel.getName());
		
		SmResponseStatus smResponseStatus = null;
		if (subjectModel.getName() == null) {
			String error = String.format("Subject name can not empty.");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = subjectService.updateSubject(subject_id, subjectModel);
		
		logger.info("Subject Sucessfully added with name [{}]",subjectModel.getName());
		return smResponseStatus;

	}
	
	@RequestMapping(value = UriConstants.SUBJECT_ID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteSubject(@PathVariable Long subject_id) {
		
		logger.info("Request received to delete Subject with id [{}]", subject_id);
		
		SmResponseStatus smResponseStatus = null;
		
		if(subject_id == null) {
			String error = String.format("subject_id can not be null/empty or zero");
			logger.error(error);
			throw new CustomException(error);
		}
		Boolean isExist = subjectService.existsById(subject_id);
		
		if(isExist.equals(Boolean.FALSE)) {
			String error = String.format("Subject with id [%s] is not exist so aborting the delete subject operation",subject_id);
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = subjectService.deleteSubject(subject_id);
		
		logger.info("Subject deleted Successfully with id [{}]", subject_id);
		return smResponseStatus;
		
	}

}
