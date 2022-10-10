package com.cds.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
//@Data : Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@AllArgsConstructor
@NoArgsConstructor
//@ToString 
@Entity
public class Personel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Please, first name can not be null!")
	@NotBlank(message = "Please, last name can not be white space!") 
	@Size(min = 2,max = 30, message = "First name '${validatedValue}' must be between{min} and {max} long")
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false, length = 30)
	private String lastName;
	
	@Column
	private String phoneNumber;
	
	@Column(nullable = false, length = 50, unique = true)
	@Email(message = "Provide valid email")
	private String email;
	
	@Column
	private String job;
	
	@Column
	private String address;
	
	
}
