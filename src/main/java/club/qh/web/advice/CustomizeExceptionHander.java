package club.qh.web.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import club.qh.web.exception.CustomizeException;

@ControllerAdvice
public class CustomizeExceptionHander {
	@ExceptionHandler(Exception.class)	
	ModelAndView handle(HttpServletRequest request, Throwable e,Model model) {
		//HttpStatus status = getStatus(request);
		if(e instanceof CustomizeException) {			
			model.addAttribute("message",e.getMessage());
		}else {
			model.addAttribute("message", "服务器热的冒烟了！请稍后再试试!");
		}		
		return new ModelAndView("error");
	}
}
