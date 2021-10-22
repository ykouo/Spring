package controller.action;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class GoEditBoardController{
	@RequestMapping("/goeditBoard.do")
	public String goeditBoard(HttpServletRequest request)  {
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardVO data = bdao.getBoard(bvo);
		request.setAttribute("data", data);
		return "editBoard";

	}
/*	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		ModelAndView mav = new ModelAndView();
		
		BoardVO data = bdao.getBoard(bvo);
		mav.addObject("data", data);
		//request.setAttribute("data", data);
		mav.setViewName("editBoard");
		
		return mav;
	}*/

}
