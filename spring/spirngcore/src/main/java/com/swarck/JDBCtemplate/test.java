package com.swarck.JDBCtemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
	public static void main(String[] args) {
		
	ApplicationContext context = new ClassPathXmlApplicationContext("com/swarck/JDBCtemplate/JdbcTemplate.xml");	
	EmployeeDao dao = (EmployeeDao) context.getBean("Employeedao");
	int status = dao.saveEmp(new Employee(102,"renish",45000));
	System.out.println(status);
		
		
	}
	
}
