package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import model.mem.MemDAO;
import model.mem.MemVO;

@Controller
public class LoginController {
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemDAO mdao = new MemDAO();
		MemVO mvo = new MemVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		
		if(mdao.getMem(mvo)) { // getMem == true 이면 로그인할 아이디 비밀번호 일치 한다는 의미 
			HttpSession session = request.getSession();
			session.setAttribute("mem", mvo.getMid());
			return "redirect:main.do";	
		}else{
			System.out.println("로그인 실패");
			return "redirect:index.jsp"; // redirect: <-- 기존의 ViewResolver의 설정을 무시하고 redirect하라는 의미
			// 정보없이 View서비스 되는것을 막기위해 url 요청으로 
		}
		
	}
	
	
	
	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemDAO mdao = new MemDAO();
		MemVO mvo = new MemVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		
		ModelAndView mav = new ModelAndView();
		
		
		if(mdao.getMem(mvo)) { // getMem == true 이면 로그인할 아이디 비밀번호 일치 한다는 의미 
			HttpSession session = request.getSession();
			session.setAttribute("mem", mvo.getMid());
			mav.setViewName("redirect:main.do");	
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("로그인 실패");
			out.println("<script>alert('login Fail');history.go(-1);</script>");
			mav.setViewName("redirect:index.jsp"); // redirect: <-- 기존의 ViewResolver의 설정을 무시하고 redirect하라는 의미
			// 정보없이 View서비스 되는것을 막기위해 url 요청으로 
		}
		return mav;

	}*/
}