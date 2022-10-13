package com.cds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cds.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

	
}
