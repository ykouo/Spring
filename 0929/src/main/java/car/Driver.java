package car;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Driver {

	public static void main(String[] args) {
//----------------------------------------------------------------------------------
		// 스프링 컨테이너를 동작시켜보자!
		// 1) 설정파일을 로딩하여 적재
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); 
		// AbstractApplicationContext  == 부모  GenericXmlApplicationContext==자식 관계
		// GenericXmlApplicationContext == 콘솔창 
		// factory ==> 객체를 여러개 생성할것이기 때문에factory
//--------------------넵--------------------------------------------------------------		
		// 2) 객체를 요청하면, 해당 객체를 제공한다.
		//	  객체를 요청 == Look up 		<-- JNDI(DBCP) 할때 나옴 
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
		// 3) 스프링 컨테이너 종료
		factory.close();
		
		// => Console
		// 현재 <bean> 등록된  모든 클래스에 대한 객체를 미리 만들어 놓는다.
		// 기본생성자 호출됨
		/*
		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationContext.xml]
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 10:49:51 KST 2021]; root of context hierarchy
		Test기본생성자 호출됨
		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@dcf3e99: startup date [Tue Sep 28 10:49:51 KST 2021]; root of context hierarchy
		 */
		// => Console
		// 현재 <bean> 등록된  모든 클래스에 대한 객체를 미리 만들어 놓는다.
		// 기본생성자 호출됨
		// 시동걸기, 액셀밟기, 시동끄기 
	}
}
