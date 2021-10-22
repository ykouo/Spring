package controller.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class DeleteBoardController implements Controller {

	@Override
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
	}
	
}
