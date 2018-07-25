package com.school.management.controller;

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
import com.school.management.model.DivisionModel;
import com.school.management.model.SchoolProfileModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.SchoolProfileService;

/**
 * 
 * @author aniket patil
 *
 */
@RestController
@RequestMapping(value = UriConstants.SCHOOL_PROFILE)
@CrossOrigin(origins = {  "http://dev.cloudscripts.co.in:8082","http://dev.cloudscripts.co.in:8081","http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class SchoolProfileController {

	@Autowired
	private SchoolProfileService schoolprofileService;

	public static final Logger logger = LoggerFactory.getLogger(SchoolProfileController.class);

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addSchoolProfile(@RequestBody SchoolProfileModel schoolProfileModel) {

		logger.info("Got request for schoolprofile  [{}]", schoolProfileModel.toString());
		return schoolprofileService.addSchoolProfile(schoolProfileModel);
	}
	
	@RequestMapping(value = UriConstants.SCHOOL_PROFILE_ID, method = RequestMethod.GET, produces = AppConstants.JSON)
	public SchoolProfileModel getSchoolProfile(@PathVariable Long school_id) {

		logger.info("Request received to fetch schoolprofile details by schoolprofile_id");
		
		SchoolProfileModel schoolProfileModel = schoolprofileService.getSchoolProfile(school_id);
		
		
		logger.info("School iD by id [{}] fetched successfully", school_id);
		
		return schoolProfileModel;
	}

}
