package com.school.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Holiday;
import com.school.management.repository.HolidayRepository;

@Component
public class HolidayDaoImpl implements HolidayDao {

	@Autowired
	private HolidayRepository holidayRepository;

	public static final Logger logger = LoggerFactory.getLogger(DivisionDaoImpl.class);

	@Override
	public void saveHoliday(Holiday holiday) {
		try {
			holidayRepository.save(holiday);
		} catch (Exception e) {
			String error = String.format("Error occured while saving holiday");
			logger.error(error);
			throw e;
		}

	}

	@Override
	public boolean isExistByName(String name) {
		boolean isExist = false;
		try {
			isExist = holidayRepository.existsByName(name);
		} catch (Exception e) {
			String error = String.format("Error occured while checking holiday existance");
			logger.error(error);
			throw e;
		}
		return isExist;

	}

	@Override
	public boolean existsById(Long holiday_id) {
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = holidayRepository.existsById(holiday_id);

		} catch (Exception e) {
			String error = String.format("Error occured while checking holiday with id [%s]", holiday_id);
			logger.error(error);
			isExist = Boolean.FALSE;
			throw e;
		}
		return isExist;
	}

	@Override
	public Holiday getHoliday(Long holiday_id) {
		Holiday holiday = new Holiday();
		try {
			holiday = holidayRepository.getOne(holiday_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching holiday details.");
			logger.error(error);
			throw e;
		}
		return holiday;

	}

	@Override
	public List<Holiday> getHolidayList() {
		List<Holiday> holidayList = new ArrayList<>();
		try {
			holidayList = holidayRepository.findAll();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching holiday list.");
			logger.error(error);
			throw e;
		}
		return holidayList;
	}

	@Override
	public void deleteHoliday(Long holiday_id) {
		try {
			holidayRepository.deleteById(holiday_id);
		} catch (Exception e) {
			String error = String.format("Error occured while deleting division with holiday_id [%s]", holiday_id);
			logger.error(error);
			throw e;
		}

	}

	@Override
	public void updateHoliday(Holiday holiday) {
		try {
			holidayRepository.save(holiday);
		} catch (Exception e) {
			String error = String.format("Error occured while updating holiday");
			logger.error(error);
			throw e;
		}

	}
}
