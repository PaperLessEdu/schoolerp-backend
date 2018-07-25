package com.school.management.dao;

import com.school.management.domain.SchoolProfile;

public interface SchoolProfileDao {

	
	public void saveSchoolProfile(SchoolProfile school);
	
	public SchoolProfile getSchoolProfile(Long schoolProfile_id);
}
