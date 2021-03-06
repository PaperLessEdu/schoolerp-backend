package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	boolean existsByName(String name);

}
