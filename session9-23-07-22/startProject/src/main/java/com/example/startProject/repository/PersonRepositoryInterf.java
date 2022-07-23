package com.example.startProject.repository;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.startProject.model.Person;

public interface PersonRepositoryInterf {

	void createPersonStatic(Person person);
	
	void createPerson(Person person)  throws SQLException ;

	Person getPersonById(int id);

	void deletePerson(int id);

}
