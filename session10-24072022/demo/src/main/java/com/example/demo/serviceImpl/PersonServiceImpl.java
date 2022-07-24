package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.PersonNotFoundException;
import com.example.demo.dtos.CreatePersonRequest;
import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepositoryInterf;
import com.example.demo.service.PersonServiceInterf;

@Service
public class PersonServiceImpl implements PersonServiceInterf{

	
	private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);


	@Autowired
	PersonRepositoryInterf personRepositoryInterf;

	@Override
	public Person createPerson(CreatePersonRequest createPersonRequest) {
		Person person = createPersonRequest.to();
		person.setAge(calculateAgeFromDOB(createPersonRequest.getDob()));
		
		Person personFromDB  = personRepositoryInterf.save(person);
		logger.info("Person Saved - {}",personFromDB);
		return personFromDB;
	}
	
	private Integer calculateAgeFromDOB(String dob) {
		
		if(dob == null) {
			return null;
		}
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();
	}

	@Override
	public Person getPersonById(int id) throws PersonNotFoundException{
		return personRepositoryInterf.findById(id).orElseThrow(
				() -> new PersonNotFoundException("Person with Id "+id+" not present!"));
	}


	@Override
	public List<Person> getAllPersons() {
		return personRepositoryInterf.findAll();
	}



}
