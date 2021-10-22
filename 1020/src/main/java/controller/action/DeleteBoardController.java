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
		System.out.println("여기는 왔니? ++");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();

		
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setMid(request.getParameter("mid"));
		System.out.println("삭제 : " + bvo);
		bdao.deleteBoard(bvo);
		System.out.println("삭제성공"); 
		return "redirect:main.do";
	
	}
/*	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("여기는 왔니? ++");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		ModelAndView mav = new ModelAndView();
		
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setMid(request.getParameter("mid"));
		System.out.println("삭제 : " + bvo);
		bdao.deleteBoard(bvo);
		System.out.println("삭제성공"); 
		mav.setViewName("redirect:main.do");
		
		return mav;
	}*/
	
}
