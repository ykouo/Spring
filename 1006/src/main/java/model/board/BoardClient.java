package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("1");
		BoardService bs=(BoardService)factory.getBean("boardService");
		
		BoardVO vo=new BoardVO();
		vo.setContent("���� �ۼ���~~");
		vo.setTitle("�����Դϴ�!");
		vo.setWriter("������");
		System.out.println("2");
		bs.insertBoard(vo);
		
		System.out.println("3");
		List<BoardVO> datas=bs.getBoardList(vo);
		for(BoardVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
	
}
