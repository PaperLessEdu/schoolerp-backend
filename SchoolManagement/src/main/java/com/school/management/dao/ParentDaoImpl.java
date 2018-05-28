package com.school.management.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Parent;
import com.school.management.repository.ParentRepository;

@Component
public class ParentDaoImpl implements ParentDao{
	
	@Autowired
	private ParentRepository parentRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ParentDaoImpl.class);

	@Override
	public Parent saveParent(Parent parent) {

		try {
			return parentRepository.save(parent);
		}catch(Exception e) {
			String error  = String.format("Error occured while saving parent with name [%s]",parent.getName());
			logger.error(error);
			throw e;
		}
	}

}
