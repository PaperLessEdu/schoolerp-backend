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
import com.school.management.domain.Division;
import com.school.management.model.DivisionModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.DivisionService;

/**
 * 
 * @author Pavan.Pawar
 *
 */

@RestController
@RequestMapping(value = UriConstants.DIVISION)
// @CrossOrigin( origins = {"http://dev.cloudscripts.co.in",
// "http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class DivisionController {

	@Autowired
	private DivisionService divisionService;

	public static final Logger logger = LoggerFactory.getLogger(DivisionController.class);

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addDivision(@RequestBody DivisionModel divisionModel) {
		logger.info("Request received to add division with name [{}]", divisionModel.getName());

		SmResponseStatus smResponseStatus = null;

		if (divisionModel.getName() == null) {
			String error = String.format("Division name can not empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = divisionService.addDivision(divisionModel);

		logger.info("Division Sucessfully added with name [{}]", divisionModel.getName());
		return smResponseStatus;

	}

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Division> listDivisions() {

		logger.info("Request received to fetch division List");

		List<Division> divisionList = new ArrayList<>();

		divisionList = divisionService.listDivision();

		logger.info("division List fetched successfully");

		return divisionList;

	}

	@RequestMapping(value = UriConstants.DIVISION_ID, method = RequestMethod.GET, produces = AppConstants.JSON)
	public DivisionModel getStandard(@PathVariable Long division_id) {

		logger.info("Request received to fetch Division details by division_id");

		DivisionModel divisionModel = divisionService.getdivision(division_id);

		logger.info("Division by id [{}] fetched successfully", division_id);

		return divisionModel;
	}

	@RequestMapping(value = UriConstants.DIVISION_ID, method = RequestMethod.PUT, produces = AppConstants.JSON)
	public SmResponseStatus updateDivision(@PathVariable Long division_id, @RequestBody DivisionModel divisionModel) {

		logger.info("Request received to update Division with name [{}]", divisionModel.getName());

		SmResponseStatus smResponseStatus = null;
		if (divisionModel.getName() == null) {
			String error = String.format("division name can not empty.");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = divisionService.updateDivision(division_id, divisionModel);

		logger.info("division Sucessfully added with name [{}]", divisionModel.getName());
		return smResponseStatus;

	}

	@RequestMapping(value = UriConstants.DIVISION_ID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteDivision(@PathVariable Long division_id) {

		logger.info("Request received to delete division with id [{}]", division_id);

		SmResponseStatus smResponseStatus = null;

		if (division_id == null) {
			String error = String.format("division_id can not be null/empty or zero");
			logger.error(error);
			throw new CustomException(error);
		}
		Boolean isExist = divisionService.existsById(division_id);

		if (isExist.equals(Boolean.FALSE)) {
			String error = String.format("division with id [%s] is not exist so aborting the delete standard operation",
					division_id);
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = divisionService.deleteDivision(division_id);

		logger.info("division deleted Successfully with id [{}]", division_id);
		return smResponseStatus;

	}

}
