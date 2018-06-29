package com.school.management.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.AcademicYearDao;
import com.school.management.dao.AcademicYearDaoImpl;
import com.school.management.dao.DivisionDaoImpl;
import com.school.management.dao.ParentDaoImpl;
import com.school.management.dao.StandardDaoImpl;
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
	
	@Autowired
	private DivisionDaoImpl divisionDaoImpl;
	
	@Autowired
	private StandardDaoImpl standardDaoImpl;
	
	@Autowired
	private AcademicYearDaoImpl academicYearDaoImpl;
	
	public static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	public SmResponseStatus addStudent(StudentModel studentModel) {
		
		String message = null;
		
		try {
			Student student = wrapStudent(null, studentModel);
			
			if(studentModel.getFathersDetails() != null) {
				Parent fatherParent = wrapParent(null, studentModel.getFathersDetails());
				student.setFather(parentDaoImpl.saveParent(fatherParent));
			}
			
			if(studentModel.getMothersDetails() != null ) {
				Parent motherParent = wrapParent(null, studentModel.getMothersDetails());
				student.setMother(parentDaoImpl.saveParent(motherParent));
			}
			
			if(studentModel.getGuardianDetails() != null) {
				Parent guardianParent = wrapParent(null, studentModel.getGuardianDetails());
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
	
	public List<Student> getStudentsByStandardAndDivision(Long standardId, Long divisionId) {
		
		try {
			List<Student> studentList  = studentDaoImpl.getStudentsByStandardAndDivision(standardId, divisionId);
			return studentList;
		} catch(Exception e) {
			String error = String.format(
					"Error occured while saving student data with standard [%s] and division [%s]",standardId, divisionId);
			logger.error(error, e);
			throw e;
		}
		
	}
	
	public StudentModel getStudentById(Long studentId) {
		
		Student student = null;
		StudentModel studentModel = new StudentModel();
		try {
			student = studentDaoImpl.getStudent(studentId);
			studentModel.wrapDetails(student);
			return studentModel;
		} catch(Exception e) {
			String error = String.format("Error while fetching student details with id [%s]", studentId);
			logger.error(error);
			throw e;
		}
	}
	
	public SmResponseStatus updateStudent(Long studentId, StudentModel studentModel) {
		String message = null;
		Student student = null;
		try {
			student = studentDaoImpl.getStudent(studentId);
			
			if(student == null) {
				String error = String.format("Student is not present with id [%s]", studentId);
				logger.error(error);
				throw new CustomException(error);
			}
			Student updateStudent = wrapStudent(studentId, studentModel);
			Parent father = wrapParent(student.getFather().getParent_id(), studentModel.getFathersDetails());
			updateStudent.setFather(parentDaoImpl.saveParent(father));
			
			Parent mother = wrapParent(student.getMother().getParent_id(), studentModel.getMothersDetails());
			updateStudent.setMother(parentDaoImpl.saveParent(mother));
			
			Parent guardian = wrapParent(student.getGuardian().getParent_id(), studentModel.getGuardianDetails());
			updateStudent.setGuardian(parentDaoImpl.saveParent(guardian));
			
			studentDaoImpl.saveStudent(updateStudent);
			
			message = String.format("Student data updated successfully with Id", studentId);
		}catch(Exception e) {
			String error = String.format(
					"Error occured while saving Student data with id [%s]",
					studentId);
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
		
	}
	
	private Student wrapStudent(Long studentId, StudentModel studentModel) {
		Student student = new Student();
		
		if(studentId != null) {
			student.setStudent_id(studentId);
		}

		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setBloodGroup(studentModel.getBloodGroup());
		student.setCategory(studentModel.getCategory());
		student.setCaste(studentModel.getCaste());
		student.setCorrespondenceAddress(studentModel.getCorrespondenceAddress());
		student.setCountry(studentModel.getCountry());
		student.setDob(studentModel.getDob());
		student.setCity(studentModel.getCity());
		student.setDivision(divisionDaoImpl.getDivision(studentModel.getDivision()));
		student.setGender(studentModel.getGender());
		student.setMiddleName(studentModel.getMiddleName());
		student.setNationality(studentModel.getNationality());
		student.setPermanentAddress(studentModel.getPermanentAddress());
		student.setPostalCode(studentModel.getPostalCode());
		student.setReligion(studentModel.getReligion());
		student.setStandard(standardDaoImpl.getStandard(studentModel.getStandard()));
		student.setState(studentModel.getState());
		student.setRollNo(studentModel.getRollNo());
		student.setDoctorName(studentModel.getDoctorName());
		student.setDoctorPhoneNo(studentModel.getDoctorPhoneNo());
		student.setDoctorAddress(studentModel.getDoctorAddress());
		student.setAdmissionDate(studentModel.getAdmissionDate());
		student.setSchoolType(studentModel.getSchoolType());
		student.setPreviousSchoolName(studentModel.getPreviousSchoolName());
		student.setBirthPlace(studentModel.getBirthPlace());
		student.setAcademicYear(academicYearDaoImpl.getAcademicYear(studentModel.getAcademicYear()));
		return student;
		
	}
	
	public SmResponseStatus deleteStudent(Long studentId) {

		String message = null;

		try {
			studentDaoImpl.deleteStudent(studentId);

			message = String.format("Student deleted successfully with id [%s]", studentId);
		} catch (Exception e) {
			String error = String.format("Error occured while deleting Student data with id [%s]", studentId);
			logger.error(error, e);
			throw e;
		}

		return new SmResponseStatus(message);
	}
	
	public Boolean existsById(Long studentId) {

		Boolean isExist = Boolean.FALSE;
		try {
			isExist = studentDaoImpl.existsById(studentId);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching Student data with id [%s]", studentId);
			logger.error(error, e);
			throw e;
		}
		return isExist;
	}
	
	private Parent wrapParent(Long parentId, ParentModel parentModel) {
		Parent parent = new Parent();
		
		if(parentId != null) {
			parent.setParent_id(parentId);
		}
		parent.setName(parentModel.getName());
		parent.setEmailId(parentModel.getEmailId());
		parent.setOccupation(parentModel.getOccupation());
		parent.setPhoneNumber(parentModel.getPhoneNumber());
		parent.setQualification(parentModel.getQualification());
		parent.setBirthDate(parentModel.getBirthdate());
		parent.setMonthlyIncome(parentModel.getMonthlyIncome());
		parent.setRelationship(parentModel.getRelationship());
		
		return parent;
	}
}
