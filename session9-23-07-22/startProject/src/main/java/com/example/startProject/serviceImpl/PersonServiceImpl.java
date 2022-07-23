package com.example.startProject.serviceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.startProject.dtos.CreatePersonRequest;
import com.example.startProject.model.Person;
import com.example.startProject.repository.PersonRepositoryInterf;
import com.example.startProject.service.PersonServiceInterf;

@Service
public class PersonServiceImpl implements PersonServiceInterf {

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
	public void deletePerson(int id) {
		personRepositoryInterf.deletePerson(id);
	}
}
