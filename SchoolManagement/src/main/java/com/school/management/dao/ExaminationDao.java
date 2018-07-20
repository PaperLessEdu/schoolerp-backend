package com.school.management.dao;

import com.school.management.domain.Examination;

public interface ExaminationDao {

	public void saveExamination(Examination examination);

	public boolean isExistByName(String name);

	public boolean existsById(Long exammaster_id);

	public Examination getExamination(Long exammaster_id);

}
