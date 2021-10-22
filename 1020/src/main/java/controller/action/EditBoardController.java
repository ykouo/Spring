package controller.action;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class EditBoardController {
	@RequestMapping("/updatepost.do")
	public String updatepost(HttpServletRequest request) {
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();	
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));

		request.setAttribute("bvo",bvo);
		bdao.updateBoard(bvo);	// �� ���������� �޾ƿ� ����, ���� ������Ʈ 
		
		return "redirect:showpost.do?bid="+bvo.getBid();

	}

	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();	
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bvo",bvo);
		
		bdao.updateBoard(bvo);	// �� ���������� �޾ƿ� ����, ���� ������Ʈ 
		
		mav.setViewName("redirect:showpost.do?bid="+bvo.getBid());
		return mav;
	}*/

}
