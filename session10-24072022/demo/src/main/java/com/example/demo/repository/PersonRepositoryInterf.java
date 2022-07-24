package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Person;

public interface PersonRepositoryInterf extends JpaRepository<Person, Integer>{

}
