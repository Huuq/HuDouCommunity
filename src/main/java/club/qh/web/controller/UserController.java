package club.qh.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.qh.web.Model.User;
import club.qh.web.dto.PaginationDTO;
import club.qh.web.mapper.UserMapper;
import club.qh.web.service.QuestionService;

@Controller
public class UserController {
	
   @Autowired
   private UserMapper userMapper;
   
   @Autowired
   private QuestionService questionService;
   
   @RequestMapping("/tohome")
   public String toHome(HttpServletRequest request,ModelMap model,@RequestParam(name="page",defaultValue = "1")Integer page
		   ,@RequestParam(name="size",defaultValue = "8")Integer size) {
	   Cookie[] cookies = request.getCookies();
	   if(cookies!=null&&cookies.length!=0) {
		   for(Cookie cookie:cookies) {
			   if(cookie.getName().equals("token")) {
				   String token = cookie.getValue();
				   User user = userMapper.findByToken(token); 
				   if(user!=null) {				
					   System.out.println(user.toString());
					   user.setName("Mr_Right");
					   request.getSession().setAttribute("user", user);
				   }
				   break;
			   }			
		   }
	   }	  
	   System.out.println("开始查询数据库问题的列表");
	   //List<QuestionDTO> questions = questionService.listQuestion(page,size);
	   PaginationDTO pagination = questionService.listQuestion(page, size);
	   model.addAttribute("pagination", pagination);	  
	   return "index";
   }	
   @RequestMapping("/wechat")
   public String weChat() {	   
	   return "wechat";
   }
}
