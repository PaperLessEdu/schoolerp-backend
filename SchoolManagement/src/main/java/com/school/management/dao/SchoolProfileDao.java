package com.school.management.dao;

import java.util.List;

import com.school.management.domain.SchoolProfile;

public interface SchoolProfileDao {

	
	public void saveSchoolProfile(SchoolProfile school);
	
	public SchoolProfile getSchoolProfile(Long schoolProfile_id);
	
	public List<SchoolProfile> getSchoolList();
}
