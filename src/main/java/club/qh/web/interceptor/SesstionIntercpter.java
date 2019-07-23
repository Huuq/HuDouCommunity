package club.qh.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import club.qh.web.Model.User;
import club.qh.web.mapper.UserMapper;
@Service
public class SesstionIntercpter implements HandlerInterceptor {
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		User user = null;
		if(cookies!=null&&cookies.length!=0) {
			   for(Cookie cookie:cookies) {
				   if(cookie.getName().equals("token")) {
					   String token = cookie.getValue();
					   user = userMapper.findByToken(token); 
					   if(user!=null) {				
						   System.out.println(user.toString());
						   user.setName("Mr_Right");
						   request.getSession().setAttribute("user", user);
					   }
					   break;
				  }			
			  }
		}	
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
   
}
