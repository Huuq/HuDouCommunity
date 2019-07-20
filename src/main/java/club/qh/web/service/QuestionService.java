package club.qh.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import club.qh.web.Model.Question;
import club.qh.web.Model.User;
import club.qh.web.dto.QuestionDTO;
import club.qh.web.mapper.QuestionMapper;
import club.qh.web.mapper.UserMapper;

@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private UserMapper userMapper;

	public List<QuestionDTO> listQuestion() {
		List<Question> list = questionMapper.listQuestion();
		List<QuestionDTO> questionDtoList = new ArrayList<QuestionDTO>();
		for(Question question:list) {
			User user = userMapper.findById(question.getCreator());
			QuestionDTO questionDto = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDto);
			questionDto.setUser(user);
			questionDtoList.add(questionDto);
		}		
		return questionDtoList;
	}
}
