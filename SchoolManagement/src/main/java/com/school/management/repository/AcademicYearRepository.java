package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.AcademicYear;

public interface AcademicYearRepository extends JpaRepository<AcademicYear, Long> {

}
