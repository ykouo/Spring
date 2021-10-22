package controller.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class EditBoardController implements Controller {


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();	
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bvo",bvo);
		
		bdao.updateBoard(bvo);	// 글 수정용으로 받아온 제목, 내용 업데이트 
		
		mav.setViewName("redirect:showpost.do?bid="+bvo.getBid());
		return mav;
	}

}
