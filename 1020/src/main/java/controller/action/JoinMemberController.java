package controller.action;



import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import model.mem.MemDAO;
import model.mem.MemVO;

@Controller
public class JoinMemberController{
	public String joinMember(HttpServletRequest request){

		MemDAO mdao = new MemDAO();
		MemVO mvo = new MemVO();

		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		mvo.setMname(request.getParameter("mname"));
		mvo.setCall(request.getParameter("call"));

		if (!mdao.checkMem(mvo)) { // false == 아이디가 없다
			mdao.insertMem(mvo);
			return "index";
		} else {
			return "insertMember";
		}
	}

	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemDAO mdao = new MemDAO();
		MemVO mvo = new MemVO();
		
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		mvo.setMname(request.getParameter("mname"));
		mvo.setCall(request.getParameter("call"));
		
		ModelAndView mav = new ModelAndView();
		
		if(!mdao.checkMem(mvo)) {	// false == 아이디가 없다 
			mdao.insertMem(mvo);
			response.setContentType("text/html; charset=UTF-8");
			mav.setViewName("index");
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('존재하는 아이디입니다.');history.go(-1);</script>");
	        mav.setViewName("insertMember");
		}
		
		return mav;
	}
*/
}
