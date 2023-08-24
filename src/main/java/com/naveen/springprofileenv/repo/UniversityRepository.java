package com.naveen.springprofileenv.repo;

import com.naveen.springprofileenv.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}