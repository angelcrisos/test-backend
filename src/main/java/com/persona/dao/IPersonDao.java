package com.persona.dao;

import org.springframework.data.repository.CrudRepository;

import com.persona.entity.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

}
