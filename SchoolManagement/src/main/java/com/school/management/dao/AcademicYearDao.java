package com.school.management.dao;

import java.util.List;

import com.school.management.domain.AcademicYear;

public interface AcademicYearDao {

	public void saveAcademicYear(AcademicYear academicYear);

	public List<AcademicYear> getAllyears();

	public void updateAcademicYear(AcademicYear academicYear);

	public void deleteById(Long accademicYearID);
}
