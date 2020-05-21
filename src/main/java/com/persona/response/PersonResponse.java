package com.persona.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private LocalDate dateOfBirth;
	
	private int age;
	
	private long birthdayDays;
	
	private Poem poem;

}
