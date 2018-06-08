package com.school.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Attendance;
import com.school.management.domain.Division;
import com.school.management.repository.AttendanceRepository;

@Component
public class AttendanceDaoImpl implements AttendanceDao {

	@Autowired
	private AttendanceRepository attendanceRepository;

	public static final Logger logger = LoggerFactory.getLogger(DivisionDaoImpl.class);

	@Override
	public void saveAttendance(Attendance attendance) {

		try {
			attendanceRepository.save(attendance);
		} catch (Exception e) {
			String error = String.format("Error occured while saving attendance");
			logger.error(error);
			throw e;
		}
	}


	/*
	 * @Override public boolean existsById(Long attendance_id) { Boolean isExist
	 * = Boolean.FALSE; try { isExist =
	 * attendanceRepository.existsById(attendance_id);
	 * 
	 * } catch(Exception e) { String error = String.format(
	 * "Error occured while checking attendance with id [%s]", attendance_id);
	 * logger.error(error); isExist = Boolean.FALSE; throw e; } return isExist;
	 * }
	 */
	@Override
	public Attendance getAttendance(Long attendance_id) {
		Attendance attendance = new Attendance();
		try {
			attendance = attendanceRepository.getOne(attendance_id);
		} catch(Exception e) {
			String error = String.format("Error occured while fetching attendance details.");
			logger.error(error);
			throw e;
		}
		return attendance;
	}

	@Override
	public List<Attendance> getAttendanceList() {
		List<Attendance> attendanceList = new ArrayList<>();
		try {
			attendanceList = attendanceRepository.findAll();
		} catch(Exception e) {
			String error = String.format("Error occured while fetching attendance list.");
			logger.error(error);
			throw e;
		}
		return attendanceList;
	}

	@Override
	public void deleteAttendance(Long attendance_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(Long attendance_id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isExistById(String is_present) {
		// TODO Auto-generated method stub
		return false;
	}

}
