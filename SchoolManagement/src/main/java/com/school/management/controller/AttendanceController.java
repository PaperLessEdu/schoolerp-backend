package com.school.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.domain.Attendance;
import com.school.management.model.AttendanceModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.AttendanceService;

@RestController
@RequestMapping(value = UriConstants.ATTENDANCE)
@CrossOrigin(origins = { "http://dev.cloudscripts.co.in", "http://localhost:4200" }, maxAge = 4800, allowCredentials = "false")
public class AttendanceController {

	public static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

	@Autowired
	public AttendanceService attendanceService;

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addAttendance(@RequestBody AttendanceModel attendanceModel) {

		logger.info("Request received to add attendance with name [{}]", attendanceModel.toString());

		SmResponseStatus smResponseStatus = null;
		;
		/*
		 * if (attendanceModel.getIs_present() == null ) { String error =
		 * String.format("Attendance name can not empty"); logger.error(error);
		 * throw new CustomException(error); }
		 */
		smResponseStatus = attendanceService.addAttendanceService(attendanceModel);

		logger.info("Attendance Sucessfully added with name [{}]", attendanceModel.getIs_present());
		return smResponseStatus;
	}

	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Attendance> getAttendanceList() {

		logger.info("Request received to fetch attedance List");

		List<Attendance> attendanceList = new ArrayList<>();

		attendanceList = attendanceService.getAttendanceList();

		logger.info("Attendance List fetched successfully");

		return attendanceList;

	}
}