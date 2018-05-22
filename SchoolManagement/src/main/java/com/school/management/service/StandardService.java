package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.StandardDaoImpl;
import com.school.management.domain.Standard;
import com.school.management.model.SmResponseStatus;
import com.school.management.model.StandardModel;

@Service
public class StandardService {
	
	@Autowired
	private StandardDaoImpl standardDaoImpl;
	
	public static final Logger logger = LoggerFactory.getLogger(StandardService.class);
	
	public SmResponseStatus addStandard(StandardModel standardModel) {
		String message = null;
		Boolean isStandardExist = null;
		Standard standard = wrapStandard(null, standardModel);
		
		isStandardExist = standardDaoImpl.isExistByName(standardModel.getName());
		logger.info("Is Standard exist: [{}]",isStandardExist);
		if(isStandardExist.equals(Boolean.FALSE)) {
			standardDaoImpl.saveStandard(standard);
		} else {
			String error = String.format("Standard is already exist with name [%s]", standardModel.getName());
			logger.error(error);
			throw new CustomException(error);
		}
		
		logger.info("Standard saved Sucessfully with name [{}]", standard.getName());
		
		message = String.format("Standard saved Sucessfully with name [%s]", standard.getName());
		
		return new SmResponseStatus(message);

	}
	
	public SmResponseStatus updateStandard(Long standard_id, StandardModel standardModel) {
		String message = null;
		Boolean isStandardExist = null;
		try {
			Standard standard = wrapStandard(standard_id, standardModel);
			isStandardExist = standardDaoImpl.isExistByName(standardModel.getName());
			logger.info("Is Standard exist: [{}]",isStandardExist);
			
			if(isStandardExist.equals(Boolean.FALSE)) {
				standardDaoImpl.updateStandard(standard);
			} else {
				String error = String.format("Updated standard is already exist with name [%s]", standardModel.getName());
				logger.error(error);
				throw new CustomException(error);
			}

			logger.info("Standard updated Sucessfully with name [{}] ",standardModel.getName());
			
			message = String.format("Standard updated Sucessfully with id [%s]",standardModel.getStandard_id());
			
		} catch (Exception e) {
			String error = String.format("Error occured while updating Standard data with name [%s]", standardModel.getName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}
	
	public List<Standard> getStandardList() {

		List<Standard> standardList = new ArrayList<>();
		try {
			standardList = standardDaoImpl.getStandardList();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching stnadard List");
			logger.error(error, e);
			throw e;
		}
		return standardList;

	}
	
	public StandardModel getStandard(Long standard_id) {

		Standard standard = null;
		StandardModel standardModel = new StandardModel();

		try {
			standard = standardDaoImpl.getStandard(standard_id);
			standardModel.wrapDetails(standard);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching standard details [%s]", standard_id);
			logger.error(error, e);
			throw e;
		}
		return standardModel;

	}
	
	public SmResponseStatus deleteStandard(Long standard_id) {
		
		String message = null;
		try {
			standardDaoImpl.deleteStandard(standard_id);
			logger.info("Standard deleted successfully [{}]", standard_id);
			message = String.format("Standard deleted successfully with id [%s]", standard_id);

		} catch (Exception e) {
			String error = String.format("Error occured while deleting standard");
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}
	
	public Boolean existsById(Long standard_id) {
		
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = standardDaoImpl.existsById(standard_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching standard data with id [%s]", standard_id);
			logger.error(error, e);
			throw e;
		}
		return isExist;
	}

	private Standard wrapStandard(Long standard_id, StandardModel standardModel) {
		Standard standard = new Standard();
		
		if(standard_id != null ) {
			standard.setStandard_id(standardModel.getStandard_id());
		}
		standard.setName(standardModel.getName());
		
		return standard;
	}
}
