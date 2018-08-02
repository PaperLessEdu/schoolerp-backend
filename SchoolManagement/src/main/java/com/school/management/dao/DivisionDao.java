package com.school.management.dao;

import java.util.List;
import com.school.management.domain.Division;

public interface DivisionDao {

	public void saveDivision(Division division);
	
	public boolean isExistByName(String name);
	
	public boolean existsById(Long division_id);
	
	public Division getDivision(Long division_id);
	
	public List<Division> getDivisionList(Long standard_id);
	
	public void deleteDivision(Long division_id);
	
	public void updateDivision(Division division);
}
