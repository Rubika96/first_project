package com.sgic.defect.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.defect.server.entities.Severity;

public interface SeverityRepository extends JpaRepository<Severity, Long>{
	
}