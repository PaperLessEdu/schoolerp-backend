package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.domain.SchoolProfile;

public interface SchoolProfileRepository extends JpaRepository<SchoolProfile, Long> {

}
