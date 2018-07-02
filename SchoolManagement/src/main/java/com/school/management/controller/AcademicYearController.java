package com.school.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.domain.AcademicYear;
import com.school.management.model.AcademicYearModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.AcamedicYearService;

/**
 * 
 * @author Pavan.Pawar
 *
 */
@RestController
@RequestMapping(value = UriConstants.ACADEMIC_YEAR)
@CrossOrigin(origins = { "http://*.cloudscripts.co.in", "http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class AcademicYearController {

	@Autowired
	private AcamedicYearService acamedicYearService;

	public static final Logger logger = LoggerFactory.getLogger(AcademicYearController.class);

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addAcademicYear(@RequestBody AcademicYearModel academicYearModel) {

		logger.info("Got request for academic year [{}]", academicYearModel.toString());
		return acamedicYearService.saveAcamedicYear(academicYearModel);
	}

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<AcademicYear> getAllAcademicYear() {

		return acamedicYearService.getAllAcademicYears();
	}

	@RequestMapping(value = UriConstants.ACADEMIC_YEAR_ID, method = RequestMethod.PUT, produces = AppConstants.JSON)
	public SmResponseStatus updateAcademicYear(@PathVariable Long academicyear_id,@RequestBody AcademicYearModel academicYearModel) {

		logger.info("Got request for update academic year [{}]", academicYearModel.toString());
		academicYearModel.setAcademicYearId(academicyear_id);
		
		return acamedicYearService.saveAcamedicYear(academicYearModel);
	}
	
	
	@RequestMapping(value = UriConstants.HOLIDAY_ID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteHoliday(@PathVariable Long holidays_id) {
	return null;
	}
}
