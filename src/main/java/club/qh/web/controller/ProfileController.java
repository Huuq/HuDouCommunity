package club.qh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
	@GetMapping("/profile/{action}")
	public String profile(@PathVariable(name="action")String action,Model model) {
		if(action.equals("questions")) {
			model.addAttribute("section", "questions");
			model.addAttribute("sectionName", "我关注的问题");
		}
		else if(action.equals("replies")) {
			model.addAttribute("section", "replies");
			model.addAttribute("sectionName", "最新回复");
		}
		return "profile";
	}

}
