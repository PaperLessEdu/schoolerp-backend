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
import com.school.management.domain.SchoolProfile;
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

		logger.info("Got request for academic year [{}]", schoolProfileModel.toString());
		return schoolprofileService.addSchoolProfile(schoolProfileModel);
	}

}
