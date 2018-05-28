package com.school.management.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.ParentDaoImpl;
import com.school.management.dao.StudentDaoImpl;
import com.school.management.domain.Parent;
import com.school.management.domain.Student;
import com.school.management.model.ParentModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.model.StudentModel;

@Service
public class StudentService {
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	@Autowired
	private ParentDaoImpl parentDaoImpl;
	
	public static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	public SmResponseStatus addStudent(StudentModel studentModel) {
		
		String message = null;
		
		try {
			Student student = wrapStudent(studentModel);
			
			if(studentModel.getFathersDetails() != null) {
				Parent fatherParent = wrapParent(studentModel.getFathersDetails());
				student.setFather(parentDaoImpl.saveParent(fatherParent));
			}
			
			if(studentModel.getFathersDetails() != null ) {
				Parent motherParent = wrapParent(studentModel.getFathersDetails());
				student.setMother(parentDaoImpl.saveParent(motherParent));
			}
			
			if(studentModel.getFathersDetails() != null) {
				Parent guardianParent = wrapParent(studentModel.getFathersDetails());
				student.setGuardian(parentDaoImpl.saveParent(guardianParent));
			}
			
			studentDaoImpl.saveStudent(student);
			
			message = String.format("Student saved successfully with first name [%s]", student.getFirstName());
			
		}catch(Exception e) {
			String error = String.format(
					"Error occured while saving student data with first name [%s] and last time [%s]",studentModel.getFirstName(),studentModel.getLastName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
		
	}
	
	private Student wrapStudent(StudentModel studentModel) {
		Student student = new Student();
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setAcademicYear(studentModel.getAcademicYear());
		student.setBloodGroup(studentModel.getBloodGroup());
		student.setCategory(studentModel.getCategory());
		student.setCaste(studentModel.getCaste());
		student.setCorrespondenceAddress(studentModel.getCorrespondenceAddress());
		student.setCountry(studentModel.getCountry());
		student.setDob(studentModel.getDob());
		student.setCity(studentModel.getCity());
		student.setDivision(studentModel.getDivision());
		student.setGender(studentModel.getGender());
		student.setMiddleName(studentModel.getMiddleName());
		student.setNationality(studentModel.getNationality());
		student.setPermanentAddress(studentModel.getPermanentAddress());
		student.setPostalCode(studentModel.getPostalCode());
		student.setReligion(studentModel.getReligion());
		student.setStandard(studentModel.getStandard());
		student.setState(studentModel.getState());
		return student;
		
	}
	
	private Parent wrapParent(ParentModel parentModel) {
		Parent parent = new Parent();
		
		parent.setName(parentModel.getName());
		parent.setEmailId(parentModel.getEmailId());
		parent.setOccupation(parentModel.getOccupation());
		parent.setPhoneNumber(parentModel.getPhoneNumber());
		parent.setQualification(parentModel.getQualification());
		
		return parent;
	}
}
