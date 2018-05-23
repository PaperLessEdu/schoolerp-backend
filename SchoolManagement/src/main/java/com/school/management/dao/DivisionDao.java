package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Division;

/**
 * 
 * @author Pavan.Pawar
 *
 */
public interface DivisionDao {

	public void saveDivision(Division division);	
	
	public boolean isExistByName(String name);
	
	public boolean existsById(Long division_id);
	
	public Division getDivision(Long divison_id);	
	
	public List<Division> getDivisionList();
	
	public void deleteDivision(long divion_id);
	
	public void updateDivision(Division division);
	
}
