package com.school.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Division;
import com.school.management.domain.Examination;
import com.school.management.repository.ExaminationRepository;

@Component

public class ExaminationDaoImpl implements ExaminationDao {

	@Autowired
	private ExaminationRepository examinationRepository;

	public static final Logger logger = LoggerFactory.getLogger(ExaminationDaoImpl.class);

	@Override
	public void saveExamination(Examination examination) {
		try {
			examinationRepository.save(examination);
		} catch (Exception e) {
			String error = String.format("Error occured while saving examination");
			logger.error(error);
			throw e;
		}

	}

	@Override
	public boolean isExistByName(String name) {
		boolean isExist = false;
		try {
			isExist = examinationRepository.existsByName(name);
		} catch (Exception e) {
			String error = String.format("Error occured while checking examination name");
			logger.error(error);
			throw e;
		}
		return isExist;
	}

	@Override
	public boolean existsById(Long exammaster_id) {
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = examinationRepository.existsById(exammaster_id);

		} catch (Exception e) {
			String error = String.format("Error occured while checking examination with id [%s]", exammaster_id);
			logger.error(error);
			isExist = Boolean.FALSE;
			throw e;
		}
		return isExist;
	}

	@Override
	public Examination getExamination(Long exammaster_id) {
		Examination examination = new Examination();
		try {
			examination = examinationRepository.getOne(exammaster_id);
		} catch (Exception e) {
			String error = String.format("Error occured while fetching division details.");
			logger.error(error);
			throw e;
		}
		return examination;
	}

	@Override
	public List<Examination> getExaminationList() {
		List<Examination> examinationList = new ArrayList<>();

		try {
			examinationList = examinationRepository.findAll();

		} catch (Exception e) {
			String error = String.format("Error occured while fetching examination list.");
			logger.error(error);
			throw e;
		}
		return examinationList;

	}

}
