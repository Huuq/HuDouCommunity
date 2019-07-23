package club.qh.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.qh.web.Model.Question;
import club.qh.web.Model.User;
import club.qh.web.mapper.QuestionMapper;

@Controller
public class PublishController {
	@Autowired
	private QuestionMapper questionMapper;

	@RequestMapping("/publish")
	public String toPublish(Question question) {
		return "publish";
	}
	
	@PostMapping("/publish")
	public String Publish(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("tag") String tag,	
			HttpServletRequest request,Model model)
	{
		System.out.println("将发布信息提交到数据库");	
		Question question = new Question();
		User user = (User)request.getSession().getAttribute("user");	
		if(user == null) {
			model.addAttribute("error", "未登录");
			return "publish";
		}
		System.out.println(title);
		question.setTitle(title);
		question.setTag(tag);
		question.setDescription(description);
		question.setGmtCreate(System.currentTimeMillis());
		question.setCreator(user.getId());
		question.setGmtModified(question.getGmtCreate());
		questionMapper.createQuestion(question);
		return "redirect:/tohome";
	}

}
