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
		
		if(mdao.getMem(mvo)) { // getMem == true �̸� �α����� ���̵� ��й�ȣ ��ġ �Ѵٴ� �ǹ� 
			HttpSession session = request.getSession();
			session.setAttribute("mem", mvo.getMid());
			return "redirect:main.do";	
		}else{
			System.out.println("�α��� ����");
			return "redirect:index.jsp"; // redirect: <-- ������ ViewResolver�� ������ �����ϰ� redirect�϶�� �ǹ�
			// �������� View���� �Ǵ°��� �������� url ��û���� 
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
		
		
		if(mdao.getMem(mvo)) { // getMem == true �̸� �α����� ���̵� ��й�ȣ ��ġ �Ѵٴ� �ǹ� 
			HttpSession session = request.getSession();
			session.setAttribute("mem", mvo.getMid());
			mav.setViewName("redirect:main.do");	
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("�α��� ����");
			out.println("<script>alert('login Fail');history.go(-1);</script>");
			mav.setViewName("redirect:index.jsp"); // redirect: <-- ������ ViewResolver�� ������ �����ϰ� redirect�϶�� �ǹ�
			// �������� View���� �Ǵ°��� �������� url ��û���� 
		}
		return mav;

	}*/
}