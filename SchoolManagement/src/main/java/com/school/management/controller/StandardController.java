package com.school.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.core.CustomException;
import com.school.management.domain.Standard;
import com.school.management.model.SmResponseStatus;
import com.school.management.model.StandardModel;
import com.school.management.service.StandardService;

@RestController
@RequestMapping (value = UriConstants.STANDARDS)
//@CrossOrigin( origins = {"http://dev.cloudscripts.co.in", "http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class StandardController {
	
	public static final Logger logger = LoggerFactory.getLogger(StandardController.class);
	
	@Autowired
	public StandardService standardService;

	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addStandard(@RequestBody StandardModel standardModel) {
		
		logger.info("Request received to add Standard with name [{}]", standardModel.getName());
		
		SmResponseStatus smResponseStatus = null;;
		if (standardModel.getName() == null ) {
			String error = String.format("Standard name can not empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = standardService.addStandard(standardModel);
		
		logger.info("Standard Sucessfully added with name [{}]", standardModel.getName());
		return smResponseStatus;
	}
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Standard> getStandardList() {

		logger.info("Request received to fetch standard List");
		
		List<Standard> standardList = new ArrayList<>();

		standardList = standardService.getStandardList();
		
		logger.info("Standard List fetched successfully");
		
		return standardList;

	}
	
	@RequestMapping(value = UriConstants.STANDARD_ID, method = RequestMethod.GET, produces = AppConstants.JSON)
	public StandardModel getStandard(@PathVariable Long standard_id) {

		logger.info("Request received to fetch Standard details by standard_id");
		
		StandardModel standardModel = standardService.getStandard(standard_id);
		
		logger.info("Standard by id [{}] fetched successfully", standard_id);
		
		return standardModel;
	}
	
	@RequestMapping(value = UriConstants.STANDARD_ID, method = RequestMethod.PUT, produces = AppConstants.JSON)
	public SmResponseStatus updateStandard(@PathVariable Long standard_id, @RequestBody StandardModel standardModel) {

		logger.info("Request received to update Standard with name [{}]",standardModel.getName());
		
		SmResponseStatus smResponseStatus = null;
		if (standardModel.getName() == null) {
			String error = String.format("Standard name can not empty.");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = standardService.updateStandard(standard_id, standardModel);
		
		logger.info("Standard Sucessfully added with name [{}]",standardModel.getName());
		return smResponseStatus;

	}
	
	@RequestMapping(value = UriConstants.STANDARD_ID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteStandard(@PathVariable Long standard_id) {
		
		logger.info("Request received to delete Standard with id [{}]", standard_id);
		
		SmResponseStatus smResponseStatus = null;
		
		if(standard_id == null) {
			String error = String.format("standard_id can not be null/empty or zero");
			logger.error(error);
			throw new CustomException(error);
		}
		Boolean isExist = standardService.existsById(standard_id);
		
		if(isExist.equals(Boolean.FALSE)) {
			String error = String.format("Standard with id [%s] is not exist so aborting the delete standard operation",standard_id);
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = standardService.deleteStandard(standard_id);
		
		logger.info("Standard deleted Successfully with id [{}]", standard_id);
		return smResponseStatus;
		
	}
}
