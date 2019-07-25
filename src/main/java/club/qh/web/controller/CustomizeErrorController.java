package club.qh.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller()
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomizeErrorController implements ErrorController {
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error";
	}
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView errorhtml(HttpServletRequest request,Model model) {
		HttpStatus status = getStatus(request);
		if(status.is1xxInformational()) {
			model.addAttribute("message", "亲：出错啦");
		}
		else if(status.is2xxSuccessful()) {
			model.addAttribute("message", "亲：出错啦");
		}
		else if(status.is3xxRedirection()) {
			model.addAttribute("message", "亲：出错啦");
		}
		else if(status.is4xxClientError()) {
			model.addAttribute("message", "你这个请求错了吧，要不然换个姿势！");
		}
		else if(status.is5xxServerError()) {
			model.addAttribute("message", "服务器热的冒烟了！请稍后再试试");
		}
		return new ModelAndView("error");		
	}
	
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
		if(statusCode==null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

}
