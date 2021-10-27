package controller.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("controller.action")
public class CommonExceptionHandler {
	
	// (NullPointerException.class) 해당 Exception발생시 해당 페이지로 이동
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handlerNullPointerException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("excep/error.jsp");
		return mav;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("excep/error.jsp");
		return mav;		
	}
	
}
