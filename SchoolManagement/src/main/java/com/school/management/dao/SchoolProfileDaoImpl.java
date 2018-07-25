package com.school.management.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.SchoolProfile;
import com.school.management.repository.SchoolProfileRepository;



@Component
public class SchoolProfileDaoImpl implements SchoolProfileDao {

	@Autowired
	private SchoolProfileRepository schoolRepository;

	public static final Logger logger = LoggerFactory.getLogger(SchoolProfileDaoImpl.class);

	@Override
	public void saveSchoolProfile(SchoolProfile school) {
		

		try {
			schoolRepository.save(school);
		} catch (Exception e) {
			String error = String.format("Error occured while saving school profile");
			logger.error(error);
			throw e;
		}
	}

}
