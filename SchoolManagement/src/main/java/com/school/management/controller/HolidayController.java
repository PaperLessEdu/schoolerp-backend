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
import com.school.management.domain.Holiday;
import com.school.management.model.HolidayModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.HolidayService;

@RestController
@RequestMapping(value = UriConstants.HOLIDAYS)
@CrossOrigin(origins = {"http://dev.cloudscripts.co.in:8082","http://dev.cloudscripts.co.in:8081",
		"http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class HolidayController {

	public static final Logger logger = LoggerFactory.getLogger(HolidayController.class);

	@Autowired
	public HolidayService holidayService;

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addHoliday(@RequestBody HolidayModel holidayModel) {

		logger.info("Request received to add Holiday with name [{}]", holidayModel.getName());

		SmResponseStatus smResponseStatus = null;
		;
		if (holidayModel.getName() == null) {
			String error = String.format("Holiday name can not empty");
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = holidayService.addHoliday(holidayModel);

		logger.info("Holiday Sucessfully added with name [{}]", holidayModel.getName());
		return smResponseStatus;
	}

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Holiday> getHolidayList() {

		logger.info("Request received to fetch holiday List");

		List<Holiday> holidayList = new ArrayList<>();

		holidayList = holidayService.getHolidayList();

		logger.info("Holiday List fetched successfully");

		return holidayList;
	}

	@RequestMapping(value = UriConstants.HOLIDAY_ID, method = RequestMethod.GET, produces = AppConstants.JSON)
	public HolidayModel getHoliday(@PathVariable Long holidays_id) {

		logger.info("Request received to fetch Holiday details by holiday_id"+holidays_id);

		HolidayModel holidayModel = holidayService.getHoliday(holidays_id);

		logger.info("Holiday by id [{}] fetched successfully", holidays_id);

		return holidayModel;
	}

	@RequestMapping(value = UriConstants.HOLIDAY_ID, method = RequestMethod.PUT, produces = AppConstants.JSON)
	public SmResponseStatus updateHoliday(@PathVariable Long holidays_id, @RequestBody HolidayModel holidayModel) {

		logger.info("Request received to update Holiday with name [{}]", holidayModel.getName());

		SmResponseStatus smResponseStatus = null;
		if (holidayModel.getName() == null) {
			String error = String.format("Holiday name can not empty.");
			logger.error(error);
			throw new CustomException(error);
		}
		holidayModel.setHoliday_id(holidays_id);
		smResponseStatus = holidayService.updateHoliday(holidays_id, holidayModel);

		logger.info("Holiday date Sucessfully added with name [{}]", holidayModel.getName());
		return smResponseStatus;
	}

	@RequestMapping(value = UriConstants.HOLIDAY_ID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteHoliday(@PathVariable Long holidays_id) {

		logger.info("Request received to delete Holiday with id [{}]", holidays_id);

		SmResponseStatus smResponseStatus = null;

		if (holidays_id == null) {
			String error = String.format("holiday_id can not be null/empty or zero");
			logger.error(error);
			throw new CustomException(error);
		}
		Boolean isExist = holidayService.existsById(holidays_id);

		if (isExist.equals(Boolean.FALSE)) {
			String error = String.format("Holiday with id [%s] is not exist so aborting the delete Holiday operation",
					holidays_id);
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = holidayService.deleteHoliday(holidays_id);

		logger.info("Holiday deleted Successfully with id [{}]", holidays_id);
		return smResponseStatus;
	}

}