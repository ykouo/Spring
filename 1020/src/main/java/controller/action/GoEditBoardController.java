package controller.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;
import model.board.BoardVO;

public class GoEditBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		ModelAndView mav = new ModelAndView();
		
		BoardVO data = bdao.getBoard(bvo);
		mav.addObject("data", data);
		//request.setAttribute("data", data);
		mav.setViewName("editBoard");
		
		return mav;
	}

}
