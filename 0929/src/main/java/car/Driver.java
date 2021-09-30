package car;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Driver {

	public static void main(String[] args) {
//----------------------------------------------------------------------------------
		// ������ �����̳ʸ� ���۽��Ѻ���!
		// 1) ���������� �ε��Ͽ� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); 
		// AbstractApplicationContext  == �θ�  GenericXmlApplicationContext==�ڽ� ����
		// GenericXmlApplicationContext == �ܼ�â 
		// factory ==> ��ü�� ������ �����Ұ��̱� ������factory
//--------------------��--------------------------------------------------------------		
		// 2) ��ü�� ��û�ϸ�, �ش� ��ü�� �����Ѵ�.
		//	  ��ü�� ��û == Look up 		<-- JNDI(DBCP) �Ҷ� ���� 
/*		System.out.println("=================================================");
		Car k = (Car)factory.getBean("kia");
		k.bootOn();
		k.bootOff();
		System.out.println("=================================================");
		Car h = (Car)factory.getBean("hy");
		h.bootOn();
		h.bootOff(); 
*/
/*		Car k = (Car)factory.getBean("kia");
		k.bootOn();
		k.bootOff();
*/
		Car kia = (Car)factory.getBean("kia");
		List<String> list = kia.getList();
		for(String v:list) {
			System.out.println(v);
		}
		
		Car kia1 = (Car)factory.getBean("kia1");
		Map<String, String> map = kia1.getMap();
		System.out.println(map);
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
