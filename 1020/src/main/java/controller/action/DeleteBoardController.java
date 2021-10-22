package controller.action;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class DeleteBoardController {
	@RequestMapping("/deletepost.do")
	public String  handleRequest(HttpServletRequest request) {
		System.out.println("����� �Դ�? ++");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();

		
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setMid(request.getParameter("mid"));
		System.out.println("���� : " + bvo);
		bdao.deleteBoard(bvo);
		System.out.println("��������"); 
		return "redirect:main.do";
	
	}
/*	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("����� �Դ�? ++");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		ModelAndView mav = new ModelAndView();
		
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setMid(request.getParameter("mid"));
		System.out.println("���� : " + bvo);
		bdao.deleteBoard(bvo);
		System.out.println("��������"); 
		mav.setViewName("redirect:main.do");
		
		return mav;
	}*/
	
}
