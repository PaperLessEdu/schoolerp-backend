package com.school.management.dao;

import com.school.management.domain.ExamResult;

public interface ExamResultDao {
	
	public void saveExamination(ExamResult examResult);

	public boolean isExistById(String is_present);

	public boolean existsById(Long exam_result_id);


}
