package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class InsertBoardController{
	// 1. POJO클래스 
	// 2. 상속xxx, 추상메서드의 강제성xxx => 함수의 input,output,함수명변경가능!
	// @RequestMapping어노테이션의 경우 어떤 메서드 수행을 할지가 목적이기 때문에 메서드 위에 달기!
	@RequestMapping("/newpost.do")
	public String insertBoard(HttpServletRequest request , BoardVO vo, BoardD){
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		
		bvo.setMid(request.getParameter("mid"));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		
		if(!bdao.insertBoard(bvo)) {
			throw new IOException("InsertBoard에서 발생한 Exception!");
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
			throw new IOException("InsertBoard에서 발생한 Exception!");
		}
		mav.setViewName("redirect:main.do");
		return mav;
	}*/
	
}
