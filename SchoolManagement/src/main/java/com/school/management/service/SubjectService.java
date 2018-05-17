package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.SubjectDaoImpl;
import com.school.management.domain.Subject;
import com.school.management.model.SmResponseStatus;

@Service
public class SubjectService {

	@Autowired
	private SubjectDaoImpl subjectDaoImpl;
	
	public static final Logger logger = LoggerFactory.getLogger(SubjectService.class);
	
	public SmResponseStatus addSubject(Subject subject) {
		String message = null;

		try {

			subjectDaoImpl.saveSubject(subject);

			logger.info("Subject Added Sucessfully with name [{}]", subject.getName());

			
			
			message = String.format("Subject saved Sucessfully with name [%s]",	subject.getName());
			
		} catch (Exception e) {
			String error = String.format(
					"Error occured while saving subject data with name [%s] ", subject.getName());
			logger.error(error, e);
			throw e;
		}
		return new SmResponseStatus(message);

	}
	
	public SmResponseStatus updateSubject(Subject subject) {
		String message = null;

		try {
			subjectDaoImpl.updateSubject(subject);

			logger.info("Subject updated Sucessfully with name [{}] ",subject.getName());
			
			message = String.format("Subject updated Sucessfully with id [%s]",subject.getSubject_id());
			
		} catch (Exception e) {
			String error = String.format("Error occured while updating subject data with name [%s]", subject.getName());
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
	
	public SmResponseStatus deleteRole(Long subject_id) {
		
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
}
