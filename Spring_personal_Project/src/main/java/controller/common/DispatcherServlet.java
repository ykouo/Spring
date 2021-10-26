package controller.common;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// DispatcherServlet == FrontController

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 추가 
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	// 로그인의 경우 LoginController 객체는 하나만 있어도 괜찮음
	// 초기화 메서드를 생성
	public void init() {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./"); // 현재디렉토리
		viewResolver.setSuffix(".jsp"); // 파일타입
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());	
	
		// HandlerMapping에게 action값을 전달, Controller객체를 반환받는다. 
		// ==> Lookup(검색, 탐색)한다 == 객체를 찾아다니는 행위 
		
		Controller controller = handlerMapping.getController(action);
		
		// 클라이언트의  요청을 실질적으로 수행하는 controller 객체!!!
		// 그 결과로 "경로"를 리턴!!
		String view = controller.execute(request, response); // 동적바인딩이 일어났다! == 다형성 적용 됐다!
		
		if(!view.contains(".do")){
			view = viewResolver.getView(view);
		}
		
		response.sendRedirect(view);
			
	}

}
