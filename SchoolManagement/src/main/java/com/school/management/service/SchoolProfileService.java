package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

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

	public SchoolProfileModel getSchoolProfile(Long school_id) {

		SchoolProfile profile = null;
		SchoolProfileModel schoolModel = new SchoolProfileModel();

		try {

			profile = schoolProfileDaoImpl.getSchoolProfile(school_id);

			schoolModel.wrapProfile(profile);

		} catch (Exception e) {
			String error = String.format("Error occured while fetching schoolprofile details [%s]", school_id);
			logger.error(error, e);
			throw e;
		}
		return schoolModel;

	}

	public List<SchoolProfile> getSchoolList() {

		List<SchoolProfile> schoolList = new ArrayList<>();
		try {
			schoolList = schoolProfileDaoImpl.getSchoolList();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching school List");
			logger.error(error, e);
			throw e;
		}
		return schoolList;

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
