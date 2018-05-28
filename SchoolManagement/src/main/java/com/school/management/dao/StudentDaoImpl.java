package com.school.management.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Student;
import com.school.management.repository.StudentRepository;


@Component
public class StudentDaoImpl implements StudentDao{

	public static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void saveStudent(Student student) {
		try {
			studentRepository.save(student);
		}catch(Exception e) {
			String error  = String.format("Error occured while saving Employee with Firstname [%s] and LastName[%s]",student.getFirstName(), student.getLastName());
			logger.error(error);
			throw e;
		}
		
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
