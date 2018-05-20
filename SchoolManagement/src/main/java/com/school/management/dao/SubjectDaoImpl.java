package com.school.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Subject;
import com.school.management.repository.SubjectRepository;

@Component
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(SubjectDaoImpl.class);
	
	@Override
	public void saveSubject(Subject subject) {
		
		try {
			subjectRepository.save(subject);
		} catch(Exception e) {
			String error = String.format("Error occured while saving subject");
			logger.error(error);
			throw e;
		}
	}

	@Override
	public boolean isExist(String name) {
		boolean isExist = false;
		try {
			isExist = subjectRepository.existsByName(name);
		} catch(Exception e) {
			String error = String.format("Error occured while checking subject existance");
			logger.error(error);
			throw e;
		}
		return isExist;
	}

	@Override
	public Subject getSubject(Long subject_id) {

		Subject subject = new Subject();
		try {
			subject = subjectRepository.getOne(subject_id);
		} catch(Exception e) {
			String error = String.format("Error occured while fetching subject details.");
			logger.error(error);
			throw e;
		}
		return subject;
	}

	@Override
	public List<Subject> getSubjectList() {
		
		List<Subject> subjectList = new ArrayList<>();
		try {
			subjectList = subjectRepository.findAll();
		} catch(Exception e) {
			String error = String.format("Error occured while fetching subject list.");
			logger.error(error);
			throw e;
		}
		return subjectList;
	}

	@Override
	public void deleteSubject(Long subject_id) {
		
		try {
			subjectRepository.deleteById(subject_id);
		} catch(Exception e) {
			String error = String.format("Error occured while deleting subject with subject_id [%s]", subject_id);
			logger.error(error);
			throw e;
		}

	}

	@Override
	public void updateSubject(Subject subject) {
		
		try {
			subjectRepository.save(subject);
		} catch (Exception e) {
			String error = String.format("Error occured while updating subject");
			logger.error(error);
			throw e;
		}
	}


}
