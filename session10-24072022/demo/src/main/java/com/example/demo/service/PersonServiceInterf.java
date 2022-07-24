package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.PersonNotFoundException;
import com.example.demo.dtos.CreatePersonRequest;
import com.example.demo.models.Person;


public interface PersonServiceInterf {
	
	Person getPersonById(int id) throws PersonNotFoundException;

	List<Person> getAllPersons();

	Person createPerson(CreatePersonRequest createPersonRequest);

}
