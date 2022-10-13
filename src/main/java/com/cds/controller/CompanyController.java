package com.cds.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.domain.Company;
import com.cds.domain.Personel;
import com.cds.service.CompanyService;
import com.cds.service.PersonelService;


@RestController
@RequestMapping("/companies")
public class CompanyController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	@GetMapping("/hi") // localhost:8080/company/hi
	public String hi() {
		return "hi everybody";
	}
	
	// Get All company
		@GetMapping

		public ResponseEntity<List<Company>> getAllCompany(HttpServletRequest request) {
			logger.warn("*****************WARNING******************{}", request.getServletPath());
			List<Company> companies = companyService.getAllCompany();
			return ResponseEntity.ok(companies);
			
		}
		
		// get personel RequestParam

		@GetMapping("/query")
		public ResponseEntity<Company> getCompanyRequestParam(@RequestParam("id") Long id) {
			Company company = companyService.findCompany(id);
			return ResponseEntity.ok(company);

		}
}
