package com.persona.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persona.dao.IPersonDao;
import com.persona.entity.Person;
import com.persona.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	IPersonDao personDao;
	
	@Override
	public List<Person> findAll() {
		return (List<Person>) personDao.findAll();
	}

	@Override
	public Person create(Person person) {
		return personDao.save(person);
	}
}
