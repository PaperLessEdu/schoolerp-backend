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
import com.school.management.domain.Division;
import com.school.management.model.DivisionModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.DivisionService;

@RestController
@RequestMapping (value = UriConstants.DIVISION)
@CrossOrigin( origins = {"http://dev.cloudscripts.co.in", "http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class DivisionController {

	public static final Logger logger = LoggerFactory.getLogger(DivisionController.class);
	
	@Autowired
	public DivisionService divisionService;
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addDivision(@RequestBody DivisionModel divisionModel) {
		
		logger.info("Request received to add Division with name [{}]", divisionModel.getName());
		
		SmResponseStatus smResponseStatus = null;;
		if (divisionModel.getName() == null ) {
			String error = String.format("Division name can not empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = divisionService.addDivision(divisionModel);
		
		logger.info("Division Sucessfully added with name [{}]", divisionModel.getName());
		return smResponseStatus;
	}
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Division> getDivisionList() {

		logger.info("Request received to fetch division List");
		
		List<Division> divisionList = new ArrayList<>();

		divisionList = divisionService.getDivisionList();
		
		logger.info("Division List fetched successfully");
		
		return divisionList;
	}
	
	@RequestMapping(value = UriConstants.DIVISION_ID, method = RequestMethod.GET, produces = AppConstants.JSON)
	public DivisionModel getDivision(@PathVariable Long division_id) {

		logger.info("Request received to fetch Division details by division_id");
		
		DivisionModel divisionModel = divisionService.getDivision(division_id);
		
		logger.info("Division by id [{}] fetched successfully", division_id);
		
		return divisionModel;
	}
	
	@RequestMapping(value = UriConstants.DIVISION_ID, method = RequestMethod.PUT, produces = AppConstants.JSON)
	public SmResponseStatus updateDivision(@PathVariable Long division_id, @RequestBody DivisionModel divisionModel) {

		logger.info("Request received to update Division with name [{}]",divisionModel.getName());
		
		SmResponseStatus smResponseStatus = null;
		if (divisionModel.getName() == null) {
			String error = String.format("Division name can not empty.");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = divisionService.updateDivision(division_id, divisionModel);
		
		logger.info("Division Sucessfully added with name [{}]",divisionModel.getName());
		return smResponseStatus;
	}
	
	@RequestMapping(value = UriConstants.DIVISION_ID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteDivision(@PathVariable Long division_id) {
		
		logger.info("Request received to delete Division with id [{}]", division_id);
		
		SmResponseStatus smResponseStatus = null;
		
		if(division_id == null) {
			String error = String.format("division_id can not be null/empty or zero");
			logger.error(error);
			throw new CustomException(error);
		}
		Boolean isExist = divisionService.existsById(division_id);
		
		if(isExist.equals(Boolean.FALSE)) {
			String error = String.format("Division with id [%s] is not exist so aborting the delete Division operation",division_id);
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = divisionService.deleteDivision(division_id);
		
		logger.info("Division deleted Successfully with id [{}]", division_id);
		return smResponseStatus;
	}
}
