package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		// ������ �����̳ʸ� ���۽��Ѻ���!
		// 1) ���������� �ε��Ͽ� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); 
		// AbstractApplicationContext  == �θ�  GenericXmlApplicationContext==�ڽ� ����
		// GenericXmlApplicationContext == �ܼ�â 
		// factory �� ��ü�� ������ �����Ұ��̱� ������factory
		
		// 2) ��ü�� ��û�ϸ�, �ش� ��ü�� �����Ѵ�.
		//	  ��ü�� ��û == Look up 		<-- JNDI(DBCP) �Ҷ� ���� 
		Test t = (Test)factory.getBean("test");
		t.print();
		
		// 3) ������ �����̳� ����
		factory.close();
		
		// �� Console
		// ���� <bean> ��ϵ�  ��� Ŭ������ ���� ��ü�� �̸� ����� ���´�.
		// �⺻������ ȣ���
		/*
		**INFO == �α� 
		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationContext.xml]
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 10:49:51 KST 2021]; root of context hierarchy
		Test�⺻������ ȣ���
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 10:49:51 KST 2021]; root of context hierarchy
		 */
		// �� Console
		// ���� <bean> ��ϵ�  ��� Ŭ������ ���� ��ü�� �̸� ����� ���´�. == pre-loading(��÷ε�)�̶�� ��
		// �̸� �������� ��ü���� POJO �� �ڹ� �ڵ��̱� ������ ������ �� ���ɿ� �׷��� ���� ������ ���� ���� 
		// �̸� �������� �ҷ����� ������ �ҷ���������. �������� ������ �ҷ����µ� �ð��� �ɸ� 
		// ���� ���� ������� �ʴ� bean�� ���� �� pre-loading �ϱ� ����  �� ��������
		// �� lazy loading(�����ε�)
		// �⺻������ ȣ���
		// ��� (print() ȣ�� )
		
		/*
		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationContext.xml]
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 11:00:04 KST 2021]; root of context hierarchy
		Test�⺻������ ȣ���
		�ȳ�!!! ���� print()!
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 11:00:04 KST 2021]; root of context hierarchy
		 */
	}
}
