package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Student;

public interface StudentDao {

	public void saveStudent(Student student);

	public void deleteStudent(Long id);

	public Boolean existsById(Long id);

	public Student getStudent(Long id);

	public List<Student> getStudentsByStandardAndDivision(Long standardId, Long divisionId);

}
