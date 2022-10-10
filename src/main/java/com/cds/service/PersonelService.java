package com.cds.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cds.domain.Personel;
import com.cds.exception.ConflictException;
import com.cds.exception.ResourceNotFoundException;
import com.cds.repository.PersonelRepository;

@Service
public class PersonelService {
	
	@Autowired
	 private PersonelRepository personelRepository;
	

	public List<Personel> getAllPersonel() {
		return personelRepository.findAll();
		
		
		
	}


	public void createPersonel( Personel personel) {
		if (personelRepository.existsByEmail(personel.getEmail())) {
			
			throw new ConflictException("Email zaten var ");
			
			
		}
	
		personelRepository.save(personel);
	}


	public Personel findPersonel(Long id) {
		return personelRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException(id+" id'li personel yok"));
		
		
	}


	public void deletePersonel(Long id) {
		personelRepository.delete(findPersonel(id));
	}


	
		
		
	}


