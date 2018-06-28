package com.school.management.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.AcademicYearDao;
import com.school.management.domain.AcademicYear;
import com.school.management.model.AcademicYearModel;
import com.school.management.model.SmResponseStatus;

/**
 * 
 * @author Pavan.Pawar
 *
 */
@Service
public class AcamedicYearService {

	@Autowired
	private AcademicYearDao academicYearDao;

	public static final Logger logger = LoggerFactory.getLogger(AcamedicYearService.class);

	public SmResponseStatus saveAcamedicYear(AcademicYearModel academicYearModel) {
		String result = null;

		AcademicYear academicYear = wrapAcamedicYear(null, academicYearModel);

		academicYearDao.saveAcademicYear(academicYear);

		result = String.format("Academic year saved Sucessfully with name [%s]", academicYearModel.getName());

		return new SmResponseStatus(result);
	}

	public SmResponseStatus updateAcamedicYear(Long academic_year_id, AcademicYearModel academicYearModel) {

		AcademicYear academicYear = wrapAcamedicYear(academic_year_id, academicYearModel);
		academicYearDao.updateAcademicYear(academicYear);

		String result = String.format("Academic year update Sucessfully with name [%s]", academicYearModel.getName());

		return new SmResponseStatus(result);

	}

	public List<AcademicYear> getAllAcademicYears() {

		return academicYearDao.getAllyears();
	}

	private AcademicYear wrapAcamedicYear(Long academic_year_id, AcademicYearModel academicYearModel) {
		AcademicYear academicYear = new AcademicYear();

		if (academic_year_id != null) {
			academicYear.setAcademicYearId(academicYearModel.getAcademicYearId());
		}
		academicYear.setName(academicYearModel.getName());
		academicYear.setStartDate(academicYearModel.getStartDate());
		academicYear.setEndDate(academicYearModel.getEndDate());
		if(academicYearModel.isCurrent()) {
			academicYear.setCurrent(academicYearModel.isCurrent());
		}
		academicYear.setWeekendType(academicYearModel.getWeekendType());

		return academicYear;
	}
}
