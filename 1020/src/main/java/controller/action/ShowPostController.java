package controller.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;
import model.board.BoardVO;

public class ShowPostController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("여기있니?");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		ModelAndView mav = new ModelAndView();
		bvo.setBid(Integer.parseInt(request.getParameter("bid"))); //여기...
		
		BoardVO data = bdao.getBoard(bvo);
		mav.addObject("data", data);
		//equest.setAttribute("data", data);

		mav.setViewName("getBoard"); // <-- getBoard 가 
		return mav;
	}

}
