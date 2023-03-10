	package com.springcore.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Emp {
	private String employeeaName;
	private List<String> phones;	
	private Set<String> addresses;
	private Map<String,String> courses;
	public String getEmployeeaName() {
		return employeeaName;
	}
	public void setEmployeeaName(String employeeaName) {
		this.employeeaName = employeeaName;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public Set<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	public Emp(String employeeaName, List<String> phones, Set<String> addresses, Map<String, String> courses) {
		super();
		this.employeeaName = employeeaName;
		this.phones = phones;
		this.addresses = addresses;
		this.courses = courses;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
