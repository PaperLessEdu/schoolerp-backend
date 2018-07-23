package com.school.management.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.SchoolProfileDaoImpl;
import com.school.management.domain.SchoolProfile;
import com.school.management.model.SchoolProfileModel;
import com.school.management.model.SmResponseStatus;


@Service

public class SchoolProfileService {
@Autowired
private SchoolProfileDaoImpl schoolprofileDaoImpl;
	
	public static final Logger logger = LoggerFactory.getLogger(SchoolProfileService.class);
	
	public SmResponseStatus addSchoolProfile(SchoolProfileModel schoolModel) {
		String message = null;
		Boolean isSchoolProfileExist = null;
		SchoolProfile school = wrapSchool(null, schoolModel);
		
		/*isSchoolProfileExist = schoolprofileDaoImpl.isExistByName(schoolModel.getBranch_name());
		logger.info("Is school profile exist: [{}]",isDivisionExist);
		if(isDivisionExist.equals(Boolean.FALSE)) {
			divisionDaoImpl.saveDivision(division);
		} else {
			String error = String.format("Division is already exist with name [%s]", divisionModel.getName());
			logger.error(error);
			throw new CustomException(error);
		}
		
		logger.info("Division saved Sucessfully with name [{}]", division.getName());
		
		message = String.format("Division saved Sucessfully with name [%s]", division.getName());
*/		
		return null;
	}

	private SchoolProfile wrapSchool(Object object, SchoolProfileModel schoolModel) {
		// TODO Auto-generated method stub
		return null;
	}
}
