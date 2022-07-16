package com.example.startProject.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class Demo {

	private int id;
	private String name;
	private String phone;

}
