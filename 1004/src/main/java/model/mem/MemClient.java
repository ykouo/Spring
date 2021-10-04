package model.mem;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemClient {
	public static void main(String[] args) {
					AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
			
			MemService ms=(MemService)factory.getBean("memService");
			
			MemVO vo=new MemVO();
			vo.setId("timo");
			vo.setPassword("1234");
			vo.setName("티모");
			vo.setRole("사용자");
			ms.insertMem(vo);
			
			List<MemVO> datas=ms.getMemList(vo);
			for(MemVO data:datas) {
				System.out.println(data);
			}
			
			factory.close();
		}
		
}

