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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.core.CustomException;
import com.school.management.domain.Student;
import com.school.management.model.SmResponseStatus;
import com.school.management.model.StudentModel;
import com.school.management.service.StudentService;

@RestController
@RequestMapping(value =  UriConstants.STUDENT)
@CrossOrigin( origins = {"http://dev.cloudscripts.co.in", "http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired 
	private StudentService studentService;
	
	@RequestMapping(value = UriConstants.BLANK, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus addStudent(@RequestBody StudentModel studentModel) {
		
		logger.info("Request received to add student with name [{}], [{}]",studentModel.getFirstName(), studentModel.getGender());
		
		SmResponseStatus smResponseStatus = null;
		if(studentModel.getFirstName() == null || studentModel.getLastName() == null) {
			String error = String.format("Student first name/last name can not be empty");
			logger.error(error);
			throw new CustomException(error);
		}
		
		smResponseStatus = studentService.addStudent(studentModel);
		
		return smResponseStatus;
		
	}
	
	@RequestMapping(value = UriConstants.BLANK , method = RequestMethod.GET, produces = AppConstants.JSON)
	public List<Student> getStudentsByStandardAndDivision(@RequestParam(value = "standardId", required = false) Long standardId, @RequestParam(value = "divisionId", required = false) Long divisionId) {
		
		if(standardId != null) {
			logger.info("Request received to fetch Student List with standard and division [{}] [{}]",standardId, divisionId);
		} else {
			logger.info("Request received to fetch Student List ");
		}
		
		if(standardId == null && divisionId != null) {
			String error = String.format("Invalid request");
			logger.error(error);
			throw new CustomException(error);
		}
		
		List<Student> studentList = studentService.getStudentsByStandardAndDivision(standardId, divisionId);
		
		logger.info("Students successfully fetched");
		return studentList;
		
	}
	
	/**
	 * Endpoint to get Student details by id
	 * @param 		studentId
	 * @return 		Student
	 */
	@RequestMapping(value = UriConstants.STUDENT_ID, method = RequestMethod.GET, produces = AppConstants.JSON)
	public StudentModel getEmployee(@PathVariable Long studentId) {

		logger.info("Request received to fetch Student details by studentid");
		
		StudentModel studentModel = studentService.getStudentById(studentId);
		
		logger.info("Student by id [{}] fetched successfully", studentId);
		
		return studentModel;

	}
	
	/**
	 * Endpoint to update student
	 * @param	StudentId
	 * @param	StudentModel
	 * @return  SmResponseStatus
	 */
	@RequestMapping(value = UriConstants.STUDENT_ID, method = RequestMethod.PUT, produces = AppConstants.JSON)
	public SmResponseStatus updateEmployee(@PathVariable Long studentId, @RequestBody StudentModel studentModel) {

		logger.info("Request received to fetch Student details by studentid");
		
		SmResponseStatus smResponseStatus = studentService.updateStudent(studentId, studentModel);
		
		logger.info("Student by id [{}] fetched successfully", studentId);
		
		return smResponseStatus;

	}
	
	@RequestMapping(value = UriConstants.STUDENT_ID, method = RequestMethod.DELETE)
	public SmResponseStatus deleteStudent(@PathVariable Long studentId) {
		
		logger.info("Request received to delete Student with id [{}]", studentId);
		
		SmResponseStatus smResponseStatus = null;
		
		if(studentId == null) {
			String error = String.format("Student id can not be null/empty or zero");
			logger.error(error);
			throw new CustomException(error);
		}
		Boolean isExist = studentService.existsById(studentId);
		
		if(isExist.equals(Boolean.FALSE)) {
			String error = String.format("Student with id [%s] is not exist so aborting the delete Student operation",studentId);
			logger.error(error);
			throw new CustomException(error);
		}
		smResponseStatus = studentService.deleteStudent(studentId);
		
		logger.info("Student deleted Successfully with id [{}]", studentId);
		return smResponseStatus;
		
	}
}
