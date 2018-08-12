package com.school.management.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.DivisionDaoImpl;
import com.school.management.dao.StandardDaoImpl;
import com.school.management.domain.Division;
import com.school.management.model.DivisionModel;
import com.school.management.model.SmResponseStatus;

@Service
public class DivisionService {

	@Autowired
	private DivisionDaoImpl divisionDaoImpl;
	
	@Autowired
	private StandardDaoImpl standardDaoImpl;
	
	public static final Logger logger = LoggerFactory.getLogger(DivisionService.class);
	
	public SmResponseStatus addDivision(Long standard_id, DivisionModel divisionModel) {
		String message = null;
		Boolean isDivisionExist = null;
		Boolean isStandardExist = null;
		Division division = wrapDivision(null, divisionModel);
		
		isStandardExist = standardDaoImpl.existsById(standard_id);
		logger.info("Is standard exist: [{}]", isStandardExist);
		if(isStandardExist.equals(Boolean.FALSE)){
			String error = String.format("Standard is not exist with id= [%d]", standard_id);
			logger.error(error);
			throw new CustomException(error);
		}
		isDivisionExist = divisionDaoImpl.existsByNameAndStandard_id(divisionModel.getName(), standard_id);
		logger.info("Is Division exist: [{}]",isDivisionExist);
		if(isDivisionExist.equals(Boolean.FALSE)) {
			divisionDaoImpl.saveDivision(division);
		} else {
			String error = String.format("Division is already exist with name [%s]", divisionModel.getName());
			logger.error(error);
			throw new CustomException(error);
		}
		
		logger.info("Division saved Sucessfully with name [{}]", division.getName());
		
		message = String.format("Division saved Sucessfully with name [%s]", division.getName());
		
		return new SmResponseStatus(message);
	}
	
	public SmResponseStatus updateDivision(Long division_id, DivisionModel divisionModel) {
		String message = null;
		Boolean isDivisionExist = null;
		try {
			Division division = wrapDivision(division_id, divisionModel);
			
			isDivisionExist = divisionDaoImpl.isExistByName(divisionModel.getName());
			logger.info("Is Division exist: [{}]",isDivisionExist);
			
			if(isDivisionExist.equals(Boolean.FALSE)) {
				divisionDaoImpl.updateDivision(division);
			} else {
				String error = String.format("Updated division is already exist with name [%s]", divisionModel.getName());
				logger.error(error);
				throw new CustomException(error);
			}

			logger.info("Division updated Sucessfully with name [{}] ",divisionModel.getName());
			
			message = String.format("Division updated Sucessfully with id [%s]",divisionModel.getDivision_id());
			
		} catch (Exception e) {
			String error = String.format("Error occured while updating Division data with name [%s]", divisionModel.getName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}
	
	public List<Division> getDivisionList(Long standard_id) {

		List<Division> divisionList = new ArrayList<>();
		try {
			divisionList = divisionDaoImpl.getDivisionList(standard_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching division List");
			logger.error(error, e);
			throw e;
		}
		return divisionList;

	}
	
	public DivisionModel getDivision(Long division_id) {

		Division division = null;
		DivisionModel divisionModel = new DivisionModel();

		try {
			division = divisionDaoImpl.getDivision(division_id);
			divisionModel.wrapDetails(division);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching division details [%s]", division_id);
			logger.error(error, e);
			throw e;
		}
		return divisionModel;

	}
	
	public SmResponseStatus deleteDivision(Long division_id) {
		
		String message = null;
		try {
			divisionDaoImpl.deleteDivision(division_id);
			logger.info("Division deleted successfully [{}]", division_id);
			message = String.format("Division deleted successfully with id [%s]", division_id);

		} catch (Exception e) {
			String error = String.format("Error occured while deleting division");
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}
	
	public Boolean existsById(Long division_id) {
		
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = divisionDaoImpl.existsById(division_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching division data with id [%s]", division_id);
			logger.error(error, e);
			throw e;
		}
		return isExist;
	}
	
	private Division wrapDivision(Long division_id, DivisionModel divisionModel) {
		Division division = new Division();
		
		if(division_id != null ) {
			division.setDivision_id(division_id);
		}
		division.setName(divisionModel.getName());
		division.setStandard(divisionModel.getStandard());
		return division;
	}
}
