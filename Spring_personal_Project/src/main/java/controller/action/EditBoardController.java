package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class EditBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();

		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));

		bdao.updateBoard(bvo);	// 글 수정용으로 받아온 제목, 내용 업데이트 

		return "showpost.do";

	}

}
