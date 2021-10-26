package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Controller;
import model.mem.MemDAO;
import model.mem.MemVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemDAO mdao = new MemDAO();
		MemVO mvo = new MemVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		
		if(mdao.getMem(mvo)) { // getMem == true 이면 로그인할 아이디 비밀번호 일치 한다는 의미 
			HttpSession session = request.getSession();
			session.setAttribute("mem", mvo.getMid());
			return "main.do";
			
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("로그인 실패");
			out.println("<script>alert('login Fail');history.go(-1);</script>");
			return "index";
		}		
	}

}
