package com.school.management.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.school.management.domain.Examination;

@Component

public class ExaminationDaoImpl implements ExaminationDao {

	public static final Logger logger = LoggerFactory.getLogger(ExaminationDaoImpl.class);

	@Override
	public void saveExamination(Examination examination) {
		// TODO Auto-generated method stub

	}

}
