package club.qh.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import club.qh.web.Model.User;
import club.qh.web.dto.PaginationDTO;
import club.qh.web.service.QuestionService;

@Controller
public class ProfileController {	
    @Autowired
	private QuestionService questionService;
	@GetMapping("/profile/{action}")
	public String profile(HttpServletRequest request,@PathVariable(name="action")String action,Model model
			,@RequestParam(name="page",defaultValue = "1")Integer page
			   ,@RequestParam(name="size",defaultValue = "8")Integer size) {
	
		User user = (User)request.getSession().getAttribute("user");
		if(user==null) {
			 return "redirect:/tohome";
		} 
		if(action.equals("questions")) {
			model.addAttribute("section", "questions");
			model.addAttribute("sectionName", "最新动态");
		}
		else if(action.equals("replies")) {
			model.addAttribute("section", "replies");
			model.addAttribute("sectionName", "最新回复");
		}
		System.out.println(user.getId()+"user信息打印");
		PaginationDTO pagination = questionService.list(user.getId(),page,size);
		System.out.println(pagination);
		model.addAttribute("pagination", pagination);
		return "profile";
	}

}
