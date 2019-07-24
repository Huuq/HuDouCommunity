package club.qh.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.qh.web.Model.Question;
import club.qh.web.Model.User;
import club.qh.web.dto.QuestionDTO;
import club.qh.web.service.QuestionService;

@Controller
public class PublishController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/publish/{id}")
	public String edit(@PathVariable(name="id")Integer id,Model model) {
		QuestionDTO question = questionService.getQuestionDtoById(id);
		model.addAttribute("title", question.getTitle());
		model.addAttribute("description", question.getDescription());
		model.addAttribute("tag", question.getTag());
		model.addAttribute("id", question.getId());
		System.out.println(question.getId()+"+++++++++++++");
		return "publish";
	}

	@RequestMapping("/publish")
	public String toPublish(Question question) {
		return "publish";
	}
	
	@PostMapping("/publish")
	public String Publish(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("tag") String tag,
			@RequestParam("id") Integer id,
			HttpServletRequest request,Model model)
	{	
		System.out.println("将发布信息提交到数据库");	
		Question question = new Question();
		User user = (User)request.getSession().getAttribute("user");
		model.addAttribute("title",title);
		model.addAttribute("description",description);
		model.addAttribute("tag", tag);
		if(title==""||title==null) {
		    model.addAttribute("error","问题标题不能为空！");
		    return "publish";
		}
		if(description==""||description==null) {
		    model.addAttribute("error", "问题描述不能为空！");
		    return "publish";
		}
		if(tag==""||tag==null) {
		    model.addAttribute("error", "便签不能为空！");
		    return "publish";
		}
		if(user == null) {
			model.addAttribute("error", "未登录");
			return "publish";
		}	
		question.setId(id);
		question.setTitle(title);
		question.setTag(tag);
		question.setDescription(description);		
		question.setCreator(user.getId());
		questionService.createOrUpdate(question);
		return "redirect:/tohome";
	}

}
