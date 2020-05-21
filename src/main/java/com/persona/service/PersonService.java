package com.persona.service;

import java.util.List;

import com.persona.entity.Person;

public interface PersonService {
	
	public List<Person> findAll();

	public Person create (Person person);
}
