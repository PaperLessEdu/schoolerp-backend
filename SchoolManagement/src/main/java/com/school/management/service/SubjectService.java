package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.SubjectDaoImpl;
import com.school.management.domain.Employee;
import com.school.management.domain.Subject;
import com.school.management.domain.UserRole;
import com.school.management.model.AddToEmployeeRequest;
import com.school.management.model.SmResponseStatus;
import com.school.management.model.SubjectModel;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class SubjectService {

	@Autowired
	private SubjectDaoImpl subjectDaoImpl;
	
	public static final Logger logger = LoggerFactory.getLogger(SubjectService.class);
	
	public SmResponseStatus addSubject(SubjectModel subjectModel) {
		String message = null;
		Boolean isSubjectExist = null;
		Subject subject = wrapSubject(null, subjectModel);
		
		isSubjectExist = subjectDaoImpl.isExist(subjectModel.getName());
		logger.info("Is Subject exist: [{}]",isSubjectExist);
		if(isSubjectExist.equals(Boolean.FALSE)) {
			subjectDaoImpl.saveSubject(subject);
		} else {
			String error = String.format("Subject is already exist with name [%s]", subjectModel.getName());
			logger.error(error);
			throw new CustomException(error);
		}
		
		logger.info("Subject saved Sucessfully with name [{}]", subject.getName());
		
		message = String.format("Subject saved Sucessfully with name [%s]", subject.getName());
		
		return new SmResponseStatus(message);

	}
	
	public SmResponseStatus updateSubject(Long subject_id, SubjectModel subjectModel) {
		String message = null;

		try {
			Subject subject = wrapSubject(subject_id, subjectModel);
			subjectDaoImpl.updateSubject(subject);

			logger.info("Subject updated Sucessfully with name [{}] ",subjectModel.getName());
			
			message = String.format("Subject updated Sucessfully with id [%s]",subjectModel.getSubject_id());
			
		} catch (Exception e) {
			String error = String.format("Error occured while updating subject data with name [%s]", subjectModel.getName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);

	}
	
	public List<Subject> getSubjectList() {

		List<Subject> subjectList = new ArrayList<>();
		try {
			subjectList = subjectDaoImpl.getSubjectList();
		} catch (Exception e) {
			String error = String.format("Error occured while fetching subject List");
			logger.error(error, e);
			throw e;
		}
		return subjectList;

	}
	
	public SubjectModel getSubject(Long subject_id) {

		Subject subject = null;
		SubjectModel subjectModel = new SubjectModel();

		try {
			subject = subjectDaoImpl.getSubject(subject_id);
			subjectModel.wrapDetails(subject);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching subject details");
			logger.error(error, e);
			throw e;
		}
		return subjectModel;

	}
	
	public SmResponseStatus deleteSubject(Long subject_id) {
		
		String message = null;
		
		try {
			
			subjectDaoImpl.deleteSubject(subject_id);
			
			logger.info("Subject deleted successfully [{}]",subject_id);
			
			message = String.format("Subject deleted successfully with id [%s]",subject_id);
			
		} catch (Exception e) {
			String error = String.format("Error occured while deleting subject");
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);
	}
	
	public Boolean existsById(Long subject_id) {

		Boolean isExist = Boolean.FALSE;
		try {
			isExist = subjectDaoImpl.existsById(subject_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching subject data with id [%s]", subject_id);
			logger.error(error, e);
			throw e;
		}
		return isExist;
	}
	
	private Subject wrapSubject(Long subject_id, SubjectModel subjectModel) {
		Subject subject = new Subject();
		
		if(subject_id != null ) {
			subject.setSubject_id(subjectModel.getSubject_id());
		}
		
		subject.setName(subjectModel.getName());
		
		return subject;
	}
	
}
