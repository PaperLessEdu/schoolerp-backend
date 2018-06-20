package com.school.management.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.AcademicYear;
import com.school.management.repository.AcademicYearRepository;

@Component
public class AcademicYearDaoImpl implements AcademicYearDao {

	@Autowired
	private AcademicYearRepository academicYearRepository;

	public static final Logger logger = LoggerFactory.getLogger(AcademicYearDaoImpl.class);

	@Override
	public void saveAcademicYear(AcademicYear academicYear) {
		academicYearRepository.save(academicYear);
	}

	@Override
	public List<AcademicYear> getAllyears() {

		return academicYearRepository.findAll();
	}

	@Override
	public void updateAcademicYear(AcademicYear academicYear) {
		academicYearRepository.save(academicYear);
	}

	@Override
	public void deleteById(Long accademicYearID) {
		academicYearRepository.deleteById(accademicYearID);

	}

}
