package com.persona.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persona.entity.Person;
import com.persona.response.PersonResponse;
import com.persona.response.Poem;
import com.persona.service.PersonService;
import com.persona.service.PoemService;
import com.persona.util.DateUtil;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class BirthdayController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	PoemService poemService;
	
	@GetMapping("/people")
	public List<PersonResponse> list(){
		List<Person> people = personService.findAll();
		List<PersonResponse> result = new ArrayList<>();
		people.stream().forEach(p-> {
			result.add(transform(p));
		});
		return result;
	}
	
	@GetMapping("/poems")
	public List<Poem> getPoems(){
		return poemService.getPoems();
	}
	
	@PostMapping("/people")
	public ResponseEntity<?> create(@Valid @RequestBody Person person, BindingResult resultError){
		Map<String, Object> result = new HashMap<>();
		Person personNew = null;
		if(resultError.hasErrors()) {
			List<String> errors = resultError.getFieldErrors().stream()
					.map(s -> "El campo " + s.getField() + " " + s.getDefaultMessage()).collect(Collectors.toList());
			result.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.BAD_REQUEST);
		}
		try {
			personNew = personService.create(person);
		}catch(DataAccessException e) {
			result.put("mensaje", "Error al realizar la creacion en bd");
			result.put("error", "Traza error " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.put("mensaje","Cliente ha sido creado con exito");
		result.put("persona",personNew);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.CREATED);
	
	}
	
	private PersonResponse transform(Person person) {
		PersonResponse response  = new PersonResponse();
		response.setId(person.getId());
		response.setName(person.getName());
		response.setLastName(person.getLastName());
		response.setDateOfBirth(person.getDateOfBirth());
		response.setAge(DateUtil.calculateAge(person.getDateOfBirth()));
		
		long days = DateUtil.calculateBirthDay(person.getDateOfBirth());
		response.setBirthdayDays(days);
		if(days == 365) {
			getPoem(response);
		}
		return response;
		
	}

	private void getPoem(PersonResponse response) {
		List<Poem> poems = poemService.getPoems();
		if(!poems.isEmpty()) {
			Random rand = new Random(); 
			response.setPoem(poems.get(rand.nextInt(poems.size())));
		}
		
	}

}
