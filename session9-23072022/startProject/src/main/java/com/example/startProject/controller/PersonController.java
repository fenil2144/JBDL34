package com.example.startProject.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.startProject.dtos.CreatePersonRequest;
import com.example.startProject.exceptions.BadPersonRequestException;
import com.example.startProject.model.Person;
import com.example.startProject.service.PersonServiceInterf;

@RestController
public class PersonController {
	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	PersonServiceInterf personServiceInterf;

//	@PostMapping("/addPerson")
//	public void createPerson(@RequestBody Person person) {
//		
//	}
	
	@PostMapping("/addPerson")
	public ResponseEntity createPerson(@RequestBody @Valid CreatePersonRequest createPersonRequest ) throws SQLException {
		logger.info("createPersonRequest - {}",createPersonRequest);
		
//		if(createPersonRequest.getFirstName() == null || createPersonRequest.getFirstName().isEmpty()) {
//			logger.info("Person FirstName is empty");
//			return;
//		}
//		
//		
//		if(createPersonRequest.getLastName() == null || createPersonRequest.getLastName().isEmpty()) {
//			logger.info("Person FirstName is empty");
//			return;
//		}
		
		//Rest of the Validations
		
		logger.info("Going to save to db");
		personServiceInterf.createPersonStatic(createPersonRequest);
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Sample_Header", "New Person type Object");
		
		return new ResponseEntity(new Person(),headers,HttpStatus.CREATED);
		
	}
	
	@GetMapping("getPerson")
	public Person getPersonById(@RequestParam("id") int id) {
		return personServiceInterf.getPersonById(id);
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public void deletePerson(@PathVariable("id") int id) throws BadPersonRequestException {
		personServiceInterf.deletePerson(id);
	}
	
	@GetMapping("getAllPersons")
	public List<Person> getAllPersons(){
		return personServiceInterf.getAllPersons();
	}

}
