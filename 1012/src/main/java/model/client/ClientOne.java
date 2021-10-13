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
		System.out.println("===========[글쓰기]===========");
		vo.setMid("관리자");
		vo.setTitle("검색테스트용");
		vo.setContent("검색 테스트중 by 관리자");
		bs.insertBoard(vo);
		System.out.println("===============================");
		System.out.println("===========[글수정]===========");
		vo.setTitle("수정테스트 ");
		vo.setContent("수정 테스트 ");
		vo.setBid(4);
		bs.updateBoard(vo);
		System.out.println("===============================");
		System.out.println("===========[글삭제]===========");
		vo.setBid(6);
		vo.setMid("관리자");
		bs.deleteBoard(vo);
		System.out.println("===============================");
		System.out.println("===========[게시글 리스트]===========");
		List<BoardVO> bl = bs.getBoardList(vo);
		for(BoardVO v : bl) {
			System.out.println(v);
		}
		System.out.println("===============================");
		System.out.println("===========[검색 결과]===========");
		BoardVO bvo = new BoardVO();
		bvo.setTitle("스프링");
		List<BoardVO>bsl = bs.searchBoard(bvo);
		for(BoardVO v:bsl) {
			System.out.println(v);
		}
		System.out.println("===============================");
		
		MemService ms =(MemService)factory.getBean("memService"); // MemServiceImpl  @Service("memService")
		
		MemVO mvo = new MemVO();
/*		mvo.setMid("a");
		mvo.setMpw("a");
		mvo.setMname("에이");
		mvo.setCall("010-aaaa-aaaa");
		mvo.setRole("USER");
		ms.insertMem(mvo);*/
		
		MemVO m = new MemVO();
		m.setMid("hana");
		m.setMpw("14");
		System.out.println("===========[로그인 결과]===========");
		MemVO login = ms.getMem(m);
		if(login!=null) {
			System.out.println(login.getMname()+"님 로그인 되었습니다.");
		}else {
			System.out.println("로그인 실패 (。_。)");
		}	
		System.out.println("===============================");
		
		
		
		
		factory.close();
	}
}
