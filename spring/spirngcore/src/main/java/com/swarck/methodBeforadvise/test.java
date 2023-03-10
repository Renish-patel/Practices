package com.swarck.methodBeforadvise;

import javax.sound.midi.VoiceStatus;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class test {
	public static void main(String args[]) {
		Resource resource = new ClassPathResource("com/swarck/methodBeforadvise/BA.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
	    A a=factory.getBean("proxy",A.class);  
		a.m();
		
		
	}
}
