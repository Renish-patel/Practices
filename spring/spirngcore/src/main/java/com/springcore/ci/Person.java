package com.springcore.ci;

import java.util.List;

public class Person {
	private String personName;
	private int personId;
	private List<String> list;
	public Person(String personName ,int personId , List<String> list) {
		this.personName = personName;
		this .personId = personId;
		this.list = list;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.personName+" : "+this.personId+" : "+this.list;
	}
}
