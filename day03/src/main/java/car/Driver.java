package car;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import test.Test;

public class Driver {

	public static void main(String[] args) {
//----------------------------------------------------------------------------------
		// ������ �����̳ʸ� ���۽��Ѻ���!
		// 1) ���������� �ε��Ͽ� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); 
		// AbstractApplicationContext  == �θ�  GenericXmlApplicationContext==�ڽ� ����
		// GenericXmlApplicationContext == �ܼ�â 
		// factory ==> ��ü�� ������ �����Ұ��̱� ������factory
//----------------------------------------------------------------------------------		
		// 2) ��ü�� ��û�ϸ�, �ش� ��ü�� �����Ѵ�.
		//	  ��ü�� ��û == Look up 		<-- JNDI(DBCP) �Ҷ� ���� 
		Car c = (Car)factory.getBean("car");
		c.bootOn();
		c.accelerator();
		c.bootOff();
//----------------------------------------------------------------------------------	
		// 3) ������ �����̳� ����
		factory.close();
		
		// => Console
		// ���� <bean> ��ϵ�  ��� Ŭ������ ���� ��ü�� �̸� ����� ���´�.
		// �⺻������ ȣ���
		/*
		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationContext.xml]
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 10:49:51 KST 2021]; root of context hierarchy
		Test�⺻������ ȣ���
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 10:49:51 KST 2021]; root of context hierarchy
		 */
		// => Console
		// ���� <bean> ��ϵ�  ��� Ŭ������ ���� ��ü�� �̸� ����� ���´�.
		// �⺻������ ȣ���
		// �õ��ɱ�, �׼����, �õ����� 
	}
}
