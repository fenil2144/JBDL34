package com.example.startProject.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.startProject.model.Person;
import com.example.startProject.repository.PersonRepositoryInterf;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryInterf{
	
	private Connection connection;
	
	private PreparedStatement preparedStatement;
	
	private static Logger logger = LoggerFactory.getLogger(PersonRepositoryImpl.class);
	
	public PersonRepositoryImpl(Connection connection) throws SQLException {
		this.connection = connection;
		createTable();
	}
	

	@Override
	public void createPersonStatic(Person person) {
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into person(id, first_name,last_name, age, dob)"+
					"VALUES(1,'PETER','DAVID',20,'1998-02-04')");
			logger.info("Insert Statement result - {}",result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void createTable() throws SQLException {
		
		Statement statement = connection.createStatement();
		statement.execute("create table if not exists person(id int primary key auto_increment, first_name varchar(30),"
				+ "last_name varchar(30),age int, dob varchar(12))");

	}
	
	public void createPerson(Person person) throws SQLException {
		
		this.preparedStatement = connection.prepareStatement("insert into person(first_name,last_name, age, dob)"+
				"VALUES(?,?,?,?)");
		
//		preparedStatement.setInt(0, person.getId());
		preparedStatement.setString(1, person.getFirstName());
		preparedStatement.setString(2, person.getLastName());
		preparedStatement.setInt(3, person.getAge());
		preparedStatement.setString(4, person.getDob());
		
		int result = preparedStatement.executeUpdate();
		
		logger.info("Insert Statement result - {}",result);

	}


	@Override
	public Person getPersonById(int id) {
		try {
			this.preparedStatement = connection.prepareStatement("select * from person where id = ?");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet =  preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				return getPersonFromResultSet(resultSet);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Person getPersonFromResultSet(ResultSet resultSet) throws SQLException{
		resultSet.getInt("id");
		resultSet.getString("first_name");
		resultSet.getString("last_name");
		resultSet.getInt(4);
		resultSet.getString(5);
		
		return Person.builder()
				.firstName(resultSet.getString("first_name"))
				.lastName(resultSet.getString("last_name"))
				.id(resultSet.getInt("id"))
				.age(resultSet.getInt(4))
				.dob(resultSet.getString(5))
				.build();
	}


	@Override
	public void deletePerson(int id) {
		
		try {
			this.preparedStatement = connection.prepareStatement("delete from person where id = ?");
			preparedStatement.setInt(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			logger.info("Delete Statement result - {}",result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
