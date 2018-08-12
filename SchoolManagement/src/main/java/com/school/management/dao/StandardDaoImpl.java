package com.school.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Standard;
import com.school.management.repository.StandardRepository;

@Component
public class StandardDaoImpl implements StandardDao {

	@Autowired
	private StandardRepository standardRepository;

	public static final Logger logger = LoggerFactory.getLogger(StandardDaoImpl.class);

	@Override
	public void saveStandard(Standard standard) {

		try {
			standardRepository.save(standard);
		} catch (Exception e) {
			String error = String.format("Error occured while saving standard");
			logger.error(error);
			throw e;
		}

	}

	@Override
	public boolean isExistByName(String name) {
		boolean isExist = false;
		try {
			isExist = standardRepository.existsByName(name);
		} catch (Exception e) {
			String error = String.format("Error occured while checking standard existance");
			logger.error(error);
			throw e;
		}
		return isExist;
	}

	@Override
	public boolean existsById(Long standard_id) {
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = standardRepository.existsById(standard_id);
			logger.info("standard is exist " + isExist);
		} catch (Exception e) {
			String error = String.format("Error occured while checking standard with id [%s]", standard_id);
			logger.error(error);
			isExist = Boolean.FALSE;
			throw e;
		}
		return isExist;
	}

	@Override
	public Standard getStandard(Long standard_id) {
		Standard standard = new Standard();
		try {
			standard = standardRepository.getOne(standard_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching standard details.");
			logger.error(error);
			throw e;
		}
		return standard;
	}

	@Override
	public List<Standard> getStandardList() {
		List<Standard> standardList = new ArrayList<>();
		try {
			standardList = standardRepository.findAll();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching standard list.");
			logger.error(error);
			throw e;
		}
		return standardList;
	}

	@Override
	public void deleteStandard(Long standard_id) {
		try {
			standardRepository.deleteById(standard_id);
		} catch (Exception e) {
			String error = String.format("Error occured while deleting standard with standard_id [%s]", standard_id);
			logger.error(error);
			throw e;
		}
	}

	@Override
	public void updateStandard(Standard standard) {
		try {
			standardRepository.save(standard);
		} catch (Exception e) {
			String error = String.format("Error occured while updating standard");
			logger.error(error);
			throw e;
		}

	}

}
