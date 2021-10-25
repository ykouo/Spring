/*package controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.board.Pagenation;

@Controller
@SessionAttributes("data")
public class BoardController {
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}	
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request,@RequestParam(value="condition",defaultValue="title",required=false)String condition,
			@RequestParam(value="keyword",defaultValue="",required=false)String keyword,
			BoardDAO bdao,BoardVO bvo,Model model,Pagenation paging){
		
		System.out.println("condition: "+condition+" /keyword : "+keyword);
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCnt = bdao.getBoardCnt();
		System.out.println("page: "+page+" /totalCnt : "+totalCnt);
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);

		page = ((page-1)*10)+1;
		paging.setPageSize(page+9);

		List<BoardVO> blist = bdao.getBoardList(page, paging.getPageSize());
		System.out.println("blist : " + blist);
		System.out.println("paging : " + paging);
		model.addAttribute("blist", blist);
		model.addAttribute("paging", paging);

		//List<BoardVO> datas = bdao.getBoardList(bvo);
		//model.addAttribute("datas", datas);
		return "main.jsp";
	}
	@RequestMapping("/showpost.do")
	public String showpost(BoardVO bvo,BoardDAO bdao,Model model){
		BoardVO data = bdao.getBoard(bvo);
		model.addAttribute("data", data);
		return "getBoard.jsp";
	}	
	@RequestMapping("/newpost.do")
	public String insertBoard(BoardVO bvo, BoardDAO bdao) throws IOException{
		if(!bdao.insertBoard(bvo)) {
			throw new IOException("InsertBoard에서 발생한 Exception!");
		}
		return "redirect:main.do";
	}
	@RequestMapping("/editBoard.do") 
	public String goeditBoard(BoardVO bvo,BoardDAO bdao,@ModelAttribute("data") Model model)  {
		System.out.println("여기왔어? 왔으면 bid 알려줘 : "); 	
		System.out.println("bid="+bvo.getBid()); 
		BoardVO data = bdao.getBoard(bvo);
		model.addAttribute("data", data);

		return "editBoard.jsp";

		System.out.println("여기 왔어?");
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		BoardVO data = bdao.getBoard(bvo);
		model.addAttribute("data", data);
		return "redirect:editBoard.jsp";
	}
	@RequestMapping("/updatepost.do")
	public String updatepost(BoardVO bvo,BoardDAO bdao,Model model) {
		bdao.updateBoard(bvo);	// 글 수정용으로 받아온 제목, 내용 업데이트 	
		model.addAttribute("bvo",bvo);
		return "redirect:showpost.do?bid="+bvo.getBid();
	}
	@RequestMapping("/deletepost.do")
	public String deletepost(BoardVO bvo,BoardDAO bdao) {		
		bdao.deleteBoard(bvo);
		System.out.println("삭제성공"); 
		return "redirect:main.do";
	}
	
	
	
}
*/