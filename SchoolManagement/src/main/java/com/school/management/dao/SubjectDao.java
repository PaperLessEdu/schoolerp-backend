package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Subject;

public interface SubjectDao {

	public void saveSubject(Subject subject);
	
	public boolean isExist(String name);
	
	public Subject getSubject(Long subject_id);
	
	public List<Subject> getSubjectList();
	
	public void deleteSubject(Long subject_id);
	
	public void updateSubject(Subject subject);
	
}
