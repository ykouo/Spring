package phone;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		System.out.println("===================ù��°������+����Ʈ��ġ=====================");
		Phone phone = (Phone)factory.getBean("phone");
		phone.power();
		phone.soundUp();
		
		System.out.println("===================�ι�°������+����Ʈ��ġ=====================");
		Phone phone2 = (Phone)factory.getBean("phone");
		phone2.power();
		phone2.soundUp();
		
/*		System.out.println("=======================ù��°������=========================");
		Phone iphone = (Phone)factory.getBean("iPhone");
		iphone.power();
		iphone.soundUp();
		iphone.soundDown();*/
		System.out.println("=======================ù��°������+���ÿ�ġ=========================");
		Phone iphone2 = (Phone)factory.getBean("iPhone2");
		iphone2.power();
		iphone2.soundUp();
		iphone2.soundDown();
		factory.close();
	}
	
}
