package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class DeleteBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("여기는 왔니? ++");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setMid(request.getParameter("mid"));
		System.out.println("삭제 : " + bvo);
		bdao.deleteBoard(bvo);
		System.out.println("삭제성공"); 
		return "main.do";

	}
	
}
