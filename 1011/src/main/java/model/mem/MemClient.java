package model.mem;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemClient {
	public static void main(String[] args) {
			AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
			
			MemService ms=(MemService)factory.getBean("memService");
			
			MemVO vo=new MemVO();
			/*	vo.setId("timo1");
			vo.setPassword("1234");
			vo.setName("Ƽ��");
			vo.setRole("user");
			ms.insertMem(vo);*/
			
			
			vo.setId("admin");
			vo.setPassword("1004");
			MemVO data = ms.getMem(vo);
			if(data!=null) {
				System.out.println("�α��εǾ����ϴ�.");
			}else {
				System.out.println("�α��� ����");
			}

			
			
/*			List<MemVO> datas=ms.getMemList(vo);
			for(MemVO mem:datas) {
				System.out.println(mem);
			}*/
			
			factory.close();
		}
		
}

