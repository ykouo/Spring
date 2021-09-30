package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Person{
	public static void main(String[] args) {

		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		CBean cb=(CBean)factory.getBean("cb");
//		Map<String,String> map=cb.getMap();
//		System.out.println(map);
		
		List<String> list=cb.getList();
		for(String v:list) {
			System.out.println(v);
		}
		
		factory.close();
		
	
	}
}
