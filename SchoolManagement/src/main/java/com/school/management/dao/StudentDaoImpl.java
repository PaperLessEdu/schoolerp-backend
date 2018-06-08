package com.school.management.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.domain.Division;
import com.school.management.domain.Standard;
import com.school.management.domain.Student;
import com.school.management.repository.StudentRepository;




@Component
public class StudentDaoImpl implements StudentDao{

	public static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	@Autowired
	private StudentRepository studentRepository;
	
	@PersistenceContext
    EntityManager entityManager;
	
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
		
		try {
			studentRepository.deleteById(id);
		} catch(Exception e) {
			String error = String.format("Error occured while deleting student with id [%s]", id);
			logger.error(error);
			throw e;
		}
		
	}

	@Override
	public Boolean existsById(Long id) {
		Boolean isExist = Boolean.FALSE;
		try {
			isExist = studentRepository.existsById(id);
			
		} catch(Exception e) {
			String error = String.format("Error occured while checking student with id [%s]", id);
			logger.error(error);
			isExist = Boolean.FALSE;
			throw e;
		}
		return isExist;
	}


	@Override
	public Student getStudent(Long id) {
		Student student = new Student();
		try {
			student = studentRepository.getOne(id);
			return student;
		} catch(Exception e) {
			String error  = String.format("Error occured while fteching student data with id [%s]",id);
			logger.error(error);
			throw e;
		}
	}

	@Override
	public List<Student> getStudentsByStandardAndDivision(Long standardId, Long divisionId) {
		
		try {
			
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
			
			Root<Student> student = criteria.from(Student.class);
			
			Join<Student,Standard> standard = student.join("standard");
			
			Join<Student,Division> division = student.join("division");
			
			criteria.select(student);
			
			if(standardId != null && divisionId != null) {
				criteria.where(builder.and(builder.equal(standard.get("standard_id"),standardId),builder.equal(division.get("division_id"),divisionId)));
			} else if(standardId != null && divisionId != null) {
				criteria.where(builder.equal(standard.get("standard_id"),standardId));
			}
			
			TypedQuery<Student> query = entityManager.createQuery(criteria);
			
			List<Student> studentList = query.getResultList();
			
			return studentList;
		} catch(Exception e) {
			String error = String.format(
					"Error occured while fetching student data with standard [%s] and division [%s]",standardId, divisionId);
			logger.info(error, e);
			throw e;
		}
	}
	

}
