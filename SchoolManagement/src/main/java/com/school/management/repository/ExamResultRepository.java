package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.domain.ExamResult;

@Repository

public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {


}
