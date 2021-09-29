package phone;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		System.out.println("===================첫번째갤럭시+스마트워치=====================");
		Phone phone = (Phone)factory.getBean("phone");
		phone.power();
		phone.soundUp();
		
		System.out.println("===================두번째갤럭시+스마트워치=====================");
		Phone phone2 = (Phone)factory.getBean("phone");
		phone2.power();
		phone2.soundUp();
		
/*		System.out.println("=======================첫번째아이폰=========================");
		Phone iphone = (Phone)factory.getBean("iPhone");
		iphone.power();
		iphone.soundUp();
		iphone.soundDown();*/
		System.out.println("=======================첫번째아이폰+애플워치=========================");
		Phone iphone2 = (Phone)factory.getBean("iPhone2");
		iphone2.power();
		iphone2.soundUp();
		iphone2.soundDown();
		factory.close();
	}
	
}
