package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.DivisionDaoImpl;
import com.school.management.domain.Division;
import com.school.management.model.DivisionModel;
import com.school.management.model.SmResponseStatus;

/**
 * 
 * @author Pavan.Pawar
 *
 */
@Service
public class DivisionService {

	@Autowired
	private DivisionDaoImpl divisiondaoImpl;

	public static final Logger logger = LoggerFactory.getLogger(DivisionService.class);

	public SmResponseStatus addDivision(DivisionModel divisionModel) {
		String message = null;
		Boolean isDivisonExists = null;
		isDivisonExists = divisiondaoImpl.isExistByName(divisionModel.getName());

		logger.info("Is Division exist: [{}]", isDivisonExists);

		Division division = wrapDivision(null, divisionModel);

		if (isDivisonExists.equals(Boolean.FALSE)) {
			divisiondaoImpl.saveDivision(division);
		} else {
			String error = String.format("Division is already exist with name [%s]", divisionModel.getName());
			logger.error(error);
			throw new CustomException(error);
		}

		logger.info("Division saved Sucessfully with name [{}]", division.getName());

		message = String.format("Division saved Sucessfully with name [%s]", division.getName());

		return new SmResponseStatus(message);
	}

	public List<Division> listDivision() {
		List<Division> divisionList = new ArrayList<>();
		try {
			divisionList = divisiondaoImpl.getDivisionList();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching Divison List");
			logger.error(error, e);
			throw e;
		}
		return divisionList;
	}

	public DivisionModel getdivision(Long division_id) {
		Division division = null;
		DivisionModel divisionModel = new DivisionModel();

		try {
			division = divisiondaoImpl.getDivision(division_id);
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
			divisiondaoImpl.deleteDivision(division_id);
			logger.info("division deleted successfully [{}]", division_id);
			message = String.format("division deleted successfully with id [%s]", division_id);

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
			isExist = divisiondaoImpl.existsById(division_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching division data with id [%s]", division_id);
			logger.error(error, e);
			throw e;
		}
		return isExist;
	}

	private Division wrapDivision(Long division_id, DivisionModel divisionModel) {
		Division division = new Division();
		if (division_id != null) {
			division.setDivision_id(divisionModel.getDivision_id());
		}
		division.setName(divisionModel.getName());

		return division;
	}

	public SmResponseStatus updateDivision(Long division_id, DivisionModel divisionModel) {
		String message = null;
		Boolean isDivisionExist = null;
		try {

			Division div = divisiondaoImpl.getDivision(division_id);

			Division division = wrapDivision(div.getDivision_id(), divisionModel);

			isDivisionExist = divisiondaoImpl.isExistByName(divisionModel.getName());
			logger.info("Is division exist: [{}]", isDivisionExist);

			if (isDivisionExist.equals(Boolean.FALSE)) {
				divisiondaoImpl.updateDivision(division);
			} else {
				String error = String.format("Updated division is already exist with name [%s]",
						divisionModel.getName());
				logger.error(error);
				throw new CustomException(error);
			}

			logger.info("division updated Sucessfully with name [{}] ", divisionModel.getName());

			message = String.format("division updated Sucessfully with id [%s]", divisionModel.getDivision_id());

		} catch (Exception e) {
			String error = String.format("Error occured while updating division data with name [%s]",
					divisionModel.getName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}

}
