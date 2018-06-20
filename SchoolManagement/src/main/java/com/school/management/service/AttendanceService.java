package com.school.management.service;

import java.util.ArrayList;
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
import com.school.management.model.AttendanceModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.model.StudentModel;

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
		SmResponseStatus response = null;

		
		// List<Long> lsids = attendanceModel.getAttendance_id();

		List<Attendance> lsAttendance = new ArrayList<>();

		for (Long student : attendanceModel.getStudentIds()) {
			Attendance att = new Attendance();
			StudentModel studentmodel = new StudentModel();

			att.setStudent(studentDaoImpl.getStudent(student));

			att.setDivision(divisionDapImpl.getDivision(attendanceModel.getDivision()));
			att.setStandard(standardDaoImpl.getStandard(attendanceModel.getStandard()));

			att.setDate(attendanceModel.getDate());

			//if (lsStudent.contains(attendanceModel.getAttendance_id())) {// absent
					
				att.setIsPresent("false");
				//} else {
				//att.setIsPresent("true");
				//}
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


	private Attendance wrapAttendance(Long attendance_id, AttendanceModel attendanceModel) {

		Attendance attendance = new Attendance();

		if (attendance_id != null) {
			attendance.setAttendance_id(attendanceModel.getAttendance_id());
		}
		attendance.setIsPresent(attendanceModel.getIs_present());

		return attendance;
	}
}
