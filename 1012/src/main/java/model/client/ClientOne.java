package model.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardDAO;
import model.board.BoardService;
import model.board.BoardVO;
import model.mem.MemService;
import model.mem.MemVO;

public class ClientOne {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs = (BoardService)factory.getBean("boardService"); // BoardServiceImpl  @Service("boardService")
		
		BoardVO vo = new BoardVO();
		System.out.println("===========[�۾���]===========");
		vo.setMid("������");
		vo.setTitle("�˻��׽�Ʈ��");
		vo.setContent("�˻� �׽�Ʈ�� by ������");
		bs.insertBoard(vo);
		System.out.println("===============================");
		System.out.println("===========[�ۼ���]===========");
		vo.setTitle("�����׽�Ʈ ");
		vo.setContent("���� �׽�Ʈ ");
		vo.setBid(4);
		bs.updateBoard(vo);
		System.out.println("===============================");
		System.out.println("===========[�ۻ���]===========");
		vo.setBid(6);
		vo.setMid("������");
		bs.deleteBoard(vo);
		System.out.println("===============================");
		System.out.println("===========[�Խñ� ����Ʈ]===========");
		List<BoardVO> bl = bs.getBoardList(vo);
		for(BoardVO v : bl) {
			System.out.println(v);
		}
		System.out.println("===============================");
		System.out.println("===========[�˻� ���]===========");
		BoardVO bvo = new BoardVO();
		bvo.setTitle("������");
		List<BoardVO>bsl = bs.searchBoard(bvo);
		for(BoardVO v:bsl) {
			System.out.println(v);
		}
		System.out.println("===============================");
		
		MemService ms =(MemService)factory.getBean("memService"); // MemServiceImpl  @Service("memService")
		
		MemVO mvo = new MemVO();
/*		mvo.setMid("a");
		mvo.setMpw("a");
		mvo.setMname("����");
		mvo.setCall("010-aaaa-aaaa");
		mvo.setRole("USER");
		ms.insertMem(mvo);*/
		
		MemVO m = new MemVO();
		m.setMid("hana");
		m.setMpw("14");
		System.out.println("===========[�α��� ���]===========");
		MemVO login = ms.getMem(m);
		if(login!=null) {
			System.out.println(login.getMname()+"�� �α��� �Ǿ����ϴ�.");
		}else {
			System.out.println("�α��� ���� (��_��)");
		}	
		System.out.println("===============================");
		
		
		
		
		factory.close();
	}
}
