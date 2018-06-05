package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.HolidayDaoImpl;
import com.school.management.domain.Holiday;
import com.school.management.model.HolidayModel;
import com.school.management.model.SmResponseStatus;

@Service
public class HolidayService {

	@Autowired
	private HolidayDaoImpl holidayDaoImpl;
	public static final Logger logger = LoggerFactory.getLogger(HolidayService.class);

	public SmResponseStatus addHoliday(HolidayModel holidayModel) {
		String message = null;
		Boolean isHolidayExist = null;
		Holiday holiday = wrapHoliday(null, holidayModel);

		isHolidayExist = holidayDaoImpl.isExistByName(holidayModel.getName());
		logger.info("Is Holiday exist: [{}]", isHolidayExist);
		if (isHolidayExist.equals(Boolean.FALSE)) {
			holidayDaoImpl.saveHoliday(holiday);
		} else {

			String error = String.format("Holiday date is already exist with name [%s]", holidayModel.getName());
			logger.error(error);
			throw new CustomException(error);
		}

		logger.info("Holiday saved Sucessfully with name [{}]", holiday.getName());

		message = String.format("Holiday saved Sucessfully with name [%s]", holiday.getName());

		return new SmResponseStatus(message);
	}

	public SmResponseStatus updateHoliday(Long holiday_id, HolidayModel holidayModel) {
		String message = null;

		try {
			Holiday holiday = wrapHoliday(holiday_id, holidayModel);

			holidayDaoImpl.updateHoliday(holiday);

			logger.info("Holiday updated Sucessfully with name [{}] ", holidayModel.getName());

			message = String.format("Holiday updated Sucessfully with id [%s]", holidayModel.getHoliday_id());

		} catch (Exception e) {
			String error = String.format("Error occured while updating Holiday data with name [%s]",
					holidayModel.getName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}

	public List<Holiday> getHolidayList() {

		List<Holiday> holidayList = new ArrayList<>();
		try {
			holidayList = holidayDaoImpl.getHolidayList();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching holiday List");
			logger.error(error, e);
			throw e;
		}
		return holidayList;

	}

	public HolidayModel getHoliday(Long holiday_id) {

		Holiday holiday = null;
		HolidayModel holidayModel = new HolidayModel();

		try {
			holiday = holidayDaoImpl.getHoliday(holiday_id);
			holidayModel.wrapDetails(holiday);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching holiday details [%s]", holiday_id);
			logger.error(error, e);
			throw e;
		}
		return holidayModel;

	}

	public SmResponseStatus deleteHoliday(Long holiday_id) {

		String message = null;
		try {
			holidayDaoImpl.deleteHoliday(holiday_id);
			logger.info("Holiday date deleted successfully [{}]", holiday_id);
			message = String.format("Holiday date deleted successfully with id [%s]", holiday_id);

		} catch (Exception e) {
			String error = String.format("Error occured while deleting holiday");
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}

	public Boolean existsById(Long holiday_id) {

		Boolean isExist = Boolean.FALSE;
		try {
			isExist = holidayDaoImpl.existsById(holiday_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching holiday data with id [%s]", holiday_id);
			logger.error(error, e);
			throw e;
		}
		return isExist;
	}

	private Holiday wrapHoliday(Long holiday_id, HolidayModel holidayModel) {
		Holiday holiday = new Holiday();

		if (holiday_id != null) {
			holiday.setHoliday_id(holidayModel.getHoliday_id());
		}
		holiday.setName(holidayModel.getName());
		holiday.setDiscription(holidayModel.getDiscription());
		holiday.setDate(holidayModel.getDate());

		return holiday;
	}
}