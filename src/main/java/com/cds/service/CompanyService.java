package com.cds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cds.domain.Company;
import com.cds.exception.ResourceNotFoundException;
import com.cds.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	 private CompanyRepository companyRepository;
	

	public List<Company> getAllCompany() {
		return companyRepository.findAll();
		
		
		
	}


	public Company findCompany(Long id) {
		
		return companyRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException(id+" id'li company yok"));
	}



}
