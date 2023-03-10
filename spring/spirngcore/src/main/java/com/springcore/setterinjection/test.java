package com.springcore.setterinjection;

import java.util.Iterator;  
import java.util.Map;  
import java.util.Set;  
import java.util.Map.Entry;  
  

public class test {
 private int id;
 private String name;
 private Map<String,String> answer;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Map<String, String> getAnswer() {
	return answer;
}
public void setAnswer(Map<String, String> answer) {
	this.answer = answer;
}
 	public void displayinfo() {
 		System.out.println("questionid"+id);
 		System.out.println("questionname"+name);
 		System.out.println("Answers.....");
 	    Set<Entry<String, String>> set=answer.entrySet();  
 	    Iterator<Entry<String, String>> itr=set.iterator();  
 		while(itr.hasNext()){
 	        Entry<String,String> entry=itr.next();  
 	        System.out.println("Answer:"+entry.getKey()+" Posted By:"+entry.getValue());  		
 		}
 	}
}
