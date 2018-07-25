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
	private SchoolProfileDaoImpl schoolProfileDaoImpl;

	public static final Logger logger = LoggerFactory.getLogger(SchoolProfileService.class);

	public SmResponseStatus addSchoolProfile(SchoolProfileModel schoolModel) {
		String message = null;
		SchoolProfile school = wrapSchool(null, schoolModel);

		schoolProfileDaoImpl.saveSchoolProfile(school);

		message = String.format("school profile saved Sucessfully with name [%s]", school.getBranch_name());

		return new SmResponseStatus(message);
	}

	private SchoolProfile wrapSchool(Long id, SchoolProfileModel schoolModel) {
		SchoolProfile school = new SchoolProfile();

		if (id != null) {
			school.setId(schoolModel.getId());
		}

		school.setAddress(schoolModel.getAddress());
		school.setBranch_name(schoolModel.getBranch_name());
		school.setEmailid(schoolModel.getEmailid());
		school.setPhone_no(schoolModel.getPhone_no());
		school.setPincode(schoolModel.getPincode());
		return school;
	}
}
