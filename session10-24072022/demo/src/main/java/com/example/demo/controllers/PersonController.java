package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PersonNotFoundException;
import com.example.demo.dtos.CreatePersonRequest;
import com.example.demo.models.Person;
import com.example.demo.service.PersonServiceInterf;


@RestController
public class PersonController {
	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	PersonServiceInterf personServiceInterf;


	
	@PostMapping("/addPerson")
	public ResponseEntity createPerson(@RequestBody @Valid CreatePersonRequest createPersonRequest ) throws SQLException {
		logger.info("createPersonRequest - {}",createPersonRequest);
		Person person = personServiceInterf.createPerson(createPersonRequest);
		
		return new ResponseEntity(person,HttpStatus.CREATED);
		
	}
	
	@GetMapping("getPerson")
	public Person getPersonById(@RequestParam("id") int id) throws PersonNotFoundException {
		return personServiceInterf.getPersonById(id);
	}
	
	@GetMapping("getAllPersons")
	public List<Person> getAllPersons(){
		return personServiceInterf.getAllPersons();
	}

}
