package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class InsertBoardController{
	// 1. POJOŬ���� 
	// 2. ���xxx, �߻�޼����� ������xxx => �Լ��� input,output,�Լ����氡��!
	// @RequestMapping������̼��� ��� � �޼��� ������ ������ �����̱� ������ �޼��� ���� �ޱ�!
	@RequestMapping("/newpost.do")
	public String insertBoard(HttpServletRequest request , BoardVO vo, BoardD){
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		
		bvo.setMid(request.getParameter("mid"));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		
		if(!bdao.insertBoard(bvo)) {
			throw new IOException("InsertBoard���� �߻��� Exception!");
		}
		return "redirect:main.do";
	}
	
	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		
		bvo.setMid(request.getParameter("mid"));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		ModelAndView mav = new ModelAndView();
		if(!bdao.insertBoard(bvo)) {
			throw new IOException("InsertBoard���� �߻��� Exception!");
		}
		mav.setViewName("redirect:main.do");
		return mav;
	}*/
	
}
