package com.swark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext contex= new ClassPathXmlApplicationContext("config.xml");
        Student Student1 = (Student) contex.getBean("Student1");
        Student Student2 =(Student) contex.getBean("Student2");
      	System.out.println(Student1);
      	System.out.println(Student2);
    }
}
