package club.qh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import club.qh.web.dto.QuestionDTO;
import club.qh.web.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@GetMapping("/question/{id}")
	public String question(@PathVariable(name="id")Integer id,Model model) {
		QuestionDTO question = questionService.getQuestionDtoById(id);
		System.out.println(question.getTitle());		
		model.addAttribute("question", question);
		return "question";
	}
}
