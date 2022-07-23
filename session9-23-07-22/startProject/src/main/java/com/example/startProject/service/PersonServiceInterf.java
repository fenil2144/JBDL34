package com.example.startProject.service;


import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.example.startProject.dtos.CreatePersonRequest;
import com.example.startProject.model.Person;

public interface PersonServiceInterf {

	void createPersonStatic(CreatePersonRequest createPersonRequest)  throws SQLException ;

	Person getPersonById(int id);

	void deletePerson(int id);

}
