package controller.action;


import java.util.List;
import javax.servlet.http.HttpServletRequest;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.board.Pagenation;

public class MainController{
	public String main(HttpServletRequest request){
		int totalCnt;
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			
		BoardDAO bdao = new BoardDAO();
		
		totalCnt = bdao.getBoardCnt();
		Pagenation paging = new Pagenation();
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);
		
		page = ((page-1)*10)+1;
		paging.setPageSize(page+9);
		
		//List<BoardVO> blist = bdao.getBoardList(bvo);
		List<BoardVO> blist = bdao.getBoardList(page, paging.getPageSize());
		
		
		request.setAttribute("blist", blist);
		
		request.setAttribute("paging", paging);
		
		return "main.jsp";
	}

	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCnt;
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			
		BoardDAO bdao = new BoardDAO();
		
		totalCnt = bdao.getBoardCnt();
		Pagenation paging = new Pagenation();
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);
		
		page = ((page-1)*10)+1;
		paging.setPageSize(page+9);
		ModelAndView mav = new ModelAndView();
		//List<BoardVO> blist = bdao.getBoardList(bvo);
		List<BoardVO> blist = bdao.getBoardList(page, paging.getPageSize());
		
		mav.addObject("blist", blist);
		//request.setAttribute("blist", blist);
		mav.addObject("paging", paging);
		//request.setAttribute("paging", paging);
		
		mav.setViewName("main");
		return mav;
	}
*/
}
