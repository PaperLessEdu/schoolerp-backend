package com.school.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.AttendanceDaoImpl;
import com.school.management.dao.DivisionDaoImpl;
import com.school.management.dao.StandardDaoImpl;
import com.school.management.dao.StudentDaoImpl;
import com.school.management.domain.Attendance;
import com.school.management.domain.Student;
import com.school.management.model.AttendanceModel;
import com.school.management.model.AttendanceReportRequester;
import com.school.management.model.AttendanceReportResponse;
import com.school.management.model.SmResponseStatus;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceDaoImpl attendanceDaoImpl;

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Autowired
	private DivisionDaoImpl divisionDapImpl;

	@Autowired
	private StandardDaoImpl standardDaoImpl;
	public static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);

	public SmResponseStatus addAttendanceService(AttendanceModel attendanceModel) {

		String result = "sucess";

		// List<Long> lsids = attendanceModel.getAttendance_id();

		List<Attendance> lsAttendance = new ArrayList<>();

		for (Long student : attendanceModel.getStudentIds()) {
			Attendance att = new Attendance();

			att.setStudent(studentDaoImpl.getStudent(student));

			att.setDivision(divisionDapImpl.getDivision(attendanceModel.getDivision()));
			att.setStandard(standardDaoImpl.getStandard(attendanceModel.getStandard()));

			att.setDate(attendanceModel.getDate());

			// if (lsStudent.contains(attendanceModel.getAttendance_id())) {//
			// absent

			att.setIsPresent("false");
			// } else {
			// att.setIsPresent("true");
			// }
			lsAttendance.add(att);
		}
		System.out.println(lsAttendance.toString());

		for (Attendance atteStore : lsAttendance) {
			try {
				attendanceDaoImpl.saveAttendance(atteStore);
			} catch (Exception e) {
				result = e.getMessage();
				logger.error("error while storing attendance ", e);

			}
		}

		return new SmResponseStatus(result);
	}

	public List<Attendance> getAttendanceList() {

		List<Attendance> attendanceList = new ArrayList<>();
		try {
			attendanceList = attendanceDaoImpl.getAttendanceList();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching attendance List");
			logger.error(error, e);
			throw e;
		}
		return attendanceList;

	}

	public List<AttendanceReportResponse> generateAtendanceReport(AttendanceReportRequester attendanceReportRequester) {

		Date startDate = null;
		Date endDate = null;

		List<AttendanceReportResponse> attendancelist = null;
		if (attendanceReportRequester.getMonth() == 0) {

			attendancelist = attendanceDaoImpl.getAtttendanceReport(attendanceReportRequester.getStandard_id(),
					attendanceReportRequester.getDivision_id());
		} else {
			
			int i = (int) (long) attendanceReportRequester.getMonth();

			switch (i) {
			case 1:
				startDate = new Date("1/1/2018");
				endDate = new Date("1/31/2018");

				break;
			case 2:
				startDate = new Date("2/1/2018");
				endDate = new Date("2/28/2018");

				break;
			case 3:
				startDate = new Date("3/1/2018");
				endDate = new Date("3/31/2018");

				break;

			case 4:
				startDate = new Date("4/1/2018");
				endDate = new Date("4/30/2018");

				break;

			case 5:
				startDate = new Date("5/1/2018");
				endDate = new Date("5/31/2018");
				break;

			case 6:
				startDate = new Date("6/1/2018");
				endDate = new Date("6/30/2018");

				break;

			case 7:
				startDate = new Date("7/1/2018");
				endDate = new Date("7/31/2018");

				break;

			case 8:
				startDate = new Date("8/1/2018");
				endDate = new Date("8/31/2018");

				break;

			case 9:
				startDate = new Date("9/1/2018");
				endDate = new Date("9/30/2018");

				break;

			case 10:
				startDate = new Date("10/1/2018");
				endDate = new Date("10/31/2018");

				break;

			case 11:
				startDate = new Date("11/1/2018");
				endDate = new Date("11/30/2018");

				break;

			case 12:
				startDate = new Date("12/1/2018");
				endDate = new Date("12/31/2018");

				break;

			}

			// call new query with date
			attendancelist = attendanceDaoImpl.getAtttendanceReportWithDate(attendanceReportRequester.getStandard_id(),
					attendanceReportRequester.getDivision_id(), startDate, endDate);

		}
		for (AttendanceReportResponse a : attendancelist) {

			Student s = studentDaoImpl.getStudent(a.getStudent_id());
			if (s != null) {
				a.setFirstName(s.getFirstName());
				a.setLastName(s.getLastName());
				a.setMiddleName(s.getMiddleName());
			} else {
				a.setFirstName("NA");
				a.setLastName("NA");
				a.setMiddleName("NA");
			}

		}

		logger.info(" attendace = " + attendancelist);

		return attendancelist;
	}

	private Attendance wrapAttendance(Long attendance_id, AttendanceModel attendanceModel) {

		Attendance attendance = new Attendance();

		if (attendance_id != null) {
			attendance.setAttendance_id(attendanceModel.getAttendance_id());
		}
		attendance.setIsPresent(attendanceModel.getIs_present());

		return attendance;
	}
}
