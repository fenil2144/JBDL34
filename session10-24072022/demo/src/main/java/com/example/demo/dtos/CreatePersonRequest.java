package com.example.demo.dtos;

import javax.validation.constraints.NotBlank;

import com.example.demo.models.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
	
	@NotBlank(message = "First Name Should Not be Empty")
	private String firstName;
	private String lastName;
	
	@NotBlank(message = "DOB Should Not be Empty")
	private String dob;
	
	public Person to() {
		return Person.builder()
				.firstName(firstName)
				.lastName(lastName)
				.dob(dob).build();
	}
}