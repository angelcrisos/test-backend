package com.persona.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.persona.dao.IPersonDao;
import com.persona.entity.Person;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonService {
	
	@Autowired
	private PersonService personService;
	
	@MockBean
	private IPersonDao personDao;
	
	@Test
    public void testCreatePerson() {
		given(personDao.save(any(Person.class))).willReturn(getPerson());
		Person result = personService.create(getPerson());
		assertNotNull("No debe ser nulo", result);
		assertEquals("Debe tener los mismos valores", "Name", result.getName());
    }
	
	@Test
    public void testList() {
		
		given(personDao.findAll()).willReturn(getListPerson());
		List<Person> result = personService.findAll();
		assertNotNull("No debe ser nulo", result);
		assertEquals("Debe tener los mismos valores", "Name", result.get(0).getName());
    }
	
	private Person getPerson() {
		Person person = new Person();
		person.setId(1l);
		person.setName("Name");
		person.setLastName("Last name");
		person.setDateOfBirth(LocalDate.now());
		return person;
	}
	
	private List<Person> getListPerson(){
		List<Person> result = new ArrayList<>();
		result.add(getPerson());
		return result;
	}

}
