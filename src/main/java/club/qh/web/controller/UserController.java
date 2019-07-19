package club.qh.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import club.qh.web.Model.User;
import club.qh.web.mapper.UserMapper;

@Controller
public class UserController {
	
   @Autowired
   private UserMapper userMapper;
   
   @RequestMapping("/tohome")
   public String toHome(HttpServletRequest request,ModelMap model) {
	   Cookie[] cookies = request.getCookies();
	   for(Cookie cookie:cookies) {
		   if(cookie.getName().equals("token")) {
			   String token = cookie.getValue();
			   User user = userMapper.findByToken(token); 
			   if(user!=null) {
				   request.getSession().setAttribute("user", user);
			   }
			   break;
		   }			
	   }	  
	   return "index";
   }	
}
