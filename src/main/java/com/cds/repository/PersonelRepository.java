package com.cds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cds.domain.Personel;


public interface PersonelRepository extends JpaRepository<Personel, Long> {

	boolean existsByEmail(String email);
	

}
