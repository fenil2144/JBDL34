package com.example.startProject.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.startProject.model.Person;

public interface PersonRepositoryInterf {

	void createPersonStatic(Person person);
	
	void createPerson(Person person)  throws SQLException ;

	Person getPersonById(int id);

	boolean deletePerson(int id);

	List<Person> getAllPersons();

}
