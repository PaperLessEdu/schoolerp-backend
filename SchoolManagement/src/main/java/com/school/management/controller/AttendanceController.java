package com.school.management.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.domain.Attendance;
import com.school.management.model.AttendanceModel;
import com.school.management.model.AttendanceReportRequester;
import com.school.management.model.AttendanceReportResponse;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.AttendanceService;

@RestController
@RequestMapping(value = UriConstants.ATTENDANCE)
@CrossOrigin(origins = { "http://dev.cloudscripts.co.in",
		"http://localhost" }, maxAge = 4800, allowCredentials = "false")
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
	public List<Attendance> getAttendanceList(@RequestParam("standard") Long standard,
			@RequestParam("division") Long division,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

		logger.info("Request received to fetch attedance List for div" + division + " standard " + standard
				+ " for date " + date);

		List<Attendance> attendanceList = new ArrayList<>();

		attendanceList = attendanceService.getAttendanceList();

		logger.info("Attendance List fetched successfully");

		return attendanceList;

	}

	@RequestMapping(value = UriConstants.ATTENDANCE_REPORT, method = RequestMethod.POST, produces = AppConstants.JSON)
	public List<AttendanceReportResponse> getattendaceReport(
			@RequestBody AttendanceReportRequester attendanceReportRequester) {
		logger.info("report request for [{}]", attendanceReportRequester.toString());

		return attendanceService.generateAtendanceReport(attendanceReportRequester);
	}

}