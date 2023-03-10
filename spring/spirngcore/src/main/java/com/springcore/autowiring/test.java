package com.springcore.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String args[]) {
		
		ApplicationContext contex = new ClassPathXmlApplicationContext("com/springcore/autowiring/autoConfig.xml");
		 Employee emp=contex.getBean("emp",Employee.class);
		System.out.print(emp);
	}
}
