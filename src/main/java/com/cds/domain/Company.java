package com.cds.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "bos gecilemez")
	@NotBlank(message = "bos gecmeyelim gardas :)")
	@Size(min = 2, max = 30, message = " name '${validatedValue}' must be between {min} and {max} long")
	@Column
	private String name;
	
	@Column
	private String phoneNumber;
	
	@Column
	@Email(message = "Gecerli bir email giriniz")
	private String email;
	
	@Column
	private String address;
	
	@OneToMany(mappedBy = "company")
	private List<Personel> personelList=new ArrayList<>();
	

}
