package com.school.management.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.ExamResult;
import com.school.management.repository.ExamResultRepository;
import com.school.management.repository.StandardRepository;

@Component
public class ExamResultDaoImpl implements ExamResultDao {

	@Autowired
	private StandardRepository standardRepository;

	@Autowired
	private ExamResultRepository examResultRepository;

	public static final Logger logger = LoggerFactory.getLogger(ExamResultDaoImpl.class);

	@Override
	public void saveExamination(ExamResult examResult) {

		try {
			examResultRepository.save(examResult);
		} catch (Exception e) {
			String error = String.format("Error occured while saving examResult");
			logger.error(error);
			throw e;
		}
	}

	@Override
	public boolean isExistById(String is_present) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long exam_result_id) {
		// TODO Auto-generated method stub
		return false;
	}

}
