package com.springcore.collections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main( String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collections/Collectionconfig.xml"); 
		Emp Emp1 = (Emp) context.getBean("Emp1");
		
		System.out.println(Emp1.getEmployeeaName());
		System.out.println(Emp1.getAddresses());
		System.out.print(Emp1.getPhones());
		System.out.print(Emp1.getCourses());

		
	}
}
