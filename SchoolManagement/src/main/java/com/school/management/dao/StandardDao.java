package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Standard;

public interface StandardDao {

	public void saveStandard(Standard standard);
	
	public boolean isExistByName(String name);
	
	public boolean existsById(Long standard_id);
	
	public Standard getStandard(Long standard_id);
	
	public List<Standard> getStandardList();
	
	public void deleteStandard(Long standard_id);
	
	public void updateStandard(Standard standard);
}
