package com.school.management.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Division;
import com.school.management.repository.DivisionRepository;
import com.school.management.repository.StandardRepository;

@Component
public class DivisionDaoImpl implements DivisionDao {

	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private StandardRepository standardRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(DivisionDaoImpl.class);
	
	@Override
	public void saveDivision(Division division) {
		try {
			divisionRepository.save(division);
		} catch(Exception e) {
			String error = String.format("Error occured while saving division");
			logger.error(error);
			throw e;
		}
	}

	@Override
	public boolean isExistByName(String name) {
		boolean isExist = false;
		try {
			isExist = divisionRepository.existsByName(name);
		} catch(Exception e) {
			String error = String.format("Error occured while checking division existance");
			logger.error(error);
			throw e;
		}
		return isExist;
	}

	@Override
	public boolean existsById(Long division_id) {
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = divisionRepository.existsById(division_id);
			
		} catch(Exception e) {
			String error = String.format("Error occured while checking division with id [%s]", division_id);
			logger.error(error);
			isExist = Boolean.FALSE;
			throw e;
		}
		return isExist;
	}

	@Override
	public Division getDivision(Long division_id) {
		Division division = new Division();
		try {
			division = divisionRepository.getOne(division_id);
		} catch(Exception e) {
			String error = String.format("Error occured while fetching division details.");
			logger.error(error);
			throw e;
		}
		return division;
	}

	@Override
	public List<Division> getDivisionList(Long standard_id) {
		List<Division> divisionList = new ArrayList<>();
		try {
			divisionRepository.findByStandardStandard_id(standard_id).forEach(divisionList::add);
		} catch(Exception e) {
			String error = String.format("Error occured while fetching division list.");
			logger.error(error);
			throw e;
		}
		return divisionList;
	}

	@Override
	public void deleteDivision(Long division_id) {
		try {
			divisionRepository.deleteById(division_id);
		} catch(Exception e) {
			String error = String.format("Error occured while deleting division with division_id [%s]", division_id);
			logger.error(error);
			throw e;
		}
	}

	@Override
	public void updateDivision(Division division) {
		try {
			divisionRepository.save(division);
		} catch (Exception e) {
			String error = String.format("Error occured while updating division");
			logger.error(error);
			throw e;
		}
	}

	public Boolean existsByNameAndStandard_id(String name, Long standard_id) {
		boolean isExist = false;
		try {
			isExist = divisionRepository.existsByNameAndStandard_id(name, standard_id);
		} catch(Exception e) {
			String error = String.format("Error occured while checking division existance");
			logger.error(error);
			throw e;
		}
		return isExist;
	}

}
