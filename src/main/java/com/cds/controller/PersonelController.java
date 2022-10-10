package com.cds.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.domain.Personel;
import com.cds.service.PersonelService;

@RestController
@RequestMapping("/personel")
public class PersonelController {

	@Autowired
	private PersonelService personelService;

	@GetMapping("/hi") // localhost:8080/personel/hi
	public String hi() {
		return "hi everybody";
	}

	// Get All personel
	@GetMapping

	public ResponseEntity<List<Personel>> getAllPersonel() {
		List<Personel> personels = personelService.getAllPersonel();
		return ResponseEntity.ok(personels);

	}

//	// create new personel 
//	  @PostMapping
//	  
//	  public ResponseEntity<String> createPersonel(@Valid @RequestBody Personel personel){
//		 personelService.createPersonel(personel);
//		 
//		  return  ResponseEntity.ok("created personel");
//		  
//	  }
	// create new personel
	@PostMapping

	public ResponseEntity<Personel> createPersonel(@Valid @RequestBody Personel personel) {
		personelService.createPersonel(personel);

		return ResponseEntity.ok(personel);

	}

	// get personel RequestParam

	@GetMapping("/query")
	public ResponseEntity<Personel> getPersonelRequestParam(@RequestParam("id") Long id) {
		Personel personel = personelService.findPersonel(id);
		return ResponseEntity.ok(personel);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Personel> getPersonelWithPathVariable(@PathVariable("id") Long id) {
		Personel personel = personelService.findPersonel(id);
		return ResponseEntity.ok(personel);

	}

//delete personel
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePersonel(@PathVariable("id")Long id) {
		personelService.deletePersonel(id);

		return ResponseEntity.ok("personel basariyla silindi");

	}
}
