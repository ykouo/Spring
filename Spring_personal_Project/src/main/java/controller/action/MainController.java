package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;
import model.board.Pagenation;

public class MainController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		return "main";
	}

}
