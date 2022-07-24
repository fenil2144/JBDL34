package com.example.startProject.serviceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.startProject.dtos.CreatePersonRequest;
import com.example.startProject.exceptions.BadPersonRequestException;
import com.example.startProject.model.Person;
import com.example.startProject.repository.PersonRepositoryInterf;
import com.example.startProject.service.PersonServiceInterf;

@Service
public class PersonServiceImpl implements PersonServiceInterf {
	
	private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);


	@Autowired
	PersonRepositoryInterf personRepositoryInterf;

	@Override
	public void createPersonStatic(CreatePersonRequest createPersonRequest) throws SQLException {
		
		Person person = createPersonRequest.to();
		if(person.getAge() == null) {
			person.setAge(calculateAgeFromDOB(person.getDob()));
		}
		
		personRepositoryInterf.createPerson(person);
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
	public Person getPersonById(int id) {
		return personRepositoryInterf.getPersonById(id);
	}

	@Override
	public Person deletePerson(int id) throws BadPersonRequestException {
		Person person = personRepositoryInterf.getPersonById(id);
		
//		if(person == null) {
//			throw new BadPersonRequestException("Person id "+id+" is not present in db");
//		}
//		personRepositoryInterf.deletePerson(id);
		
		logger.info("Person Object from Repository - {}",person);
		
		boolean isDeleted = personRepositoryInterf.deletePerson(id);
		if(isDeleted) {
			return person;
		}
		
		throw new BadPersonRequestException("Person id "+id+" is not present in db");
		
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepositoryInterf.getAllPersons();
	}
}
