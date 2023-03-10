package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/ciConfig.xml");
		Person p = (Person) context.getBean("Person1");
		System.out.print(p);
	}
}
