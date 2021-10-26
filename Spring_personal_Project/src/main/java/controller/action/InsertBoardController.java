package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class InsertBoardController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		
		bvo.setMid(request.getParameter("mid"));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		
		if(!bdao.insertBoard(bvo)) {
			throw new IOException("InsertBoard에서 발생한 Exception!");
		}
		
	
		return "main.do";
	
	}
	
}
