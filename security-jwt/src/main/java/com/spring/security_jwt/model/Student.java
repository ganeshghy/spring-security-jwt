package com.spring.security_jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	public Student(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String firstName;
	private String lastName;
}
