package club.qh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import club.qh.web.dto.PaginationDTO;
import club.qh.web.service.QuestionService;
@Controller
public class UserController {
	
   @Autowired
   private QuestionService questionService;
   
   @RequestMapping("/tohome")
   public String toHome(ModelMap model,@RequestParam(name="page",defaultValue = "1")Integer page
		   ,@RequestParam(name="size",defaultValue = "8")Integer size) {
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
