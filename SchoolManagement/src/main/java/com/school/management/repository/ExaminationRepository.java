package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.domain.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

	boolean existsByName(String name);

}
