package club.qh.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.qh.web.Model.Question;
import club.qh.web.Model.User;
import club.qh.web.dto.PaginationDTO;
import club.qh.web.dto.QuestionDTO;
import club.qh.web.mapper.QuestionMapper;
import club.qh.web.mapper.UserMapper;

@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private UserMapper userMapper;

	public PaginationDTO listQuestion(Integer page, Integer size) {
		PaginationDTO paginationDto = new PaginationDTO();
		Integer totalCount = questionMapper.count();
		paginationDto.setPagination(totalCount,page,size);
		if(page < 1) {
			page = 1;
		}
		else if(page>paginationDto.getTotalPage()) {
			page = paginationDto.getTotalPage();
		}
		page = size*(page-1);		
		List<Question> list = questionMapper.listQuestion(page,size);
		List<QuestionDTO> questionDtoList = new ArrayList<QuestionDTO>();
		for(Question question:list) {
			User user = userMapper.findById(question.getCreator());
			QuestionDTO questionDto = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDto);
			questionDto.setUser(user);
			questionDtoList.add(questionDto);
		}		
		paginationDto.setQuestion(questionDtoList);
		return paginationDto;
	}

	public PaginationDTO list(Integer userID, Integer page, Integer size) {
		PaginationDTO paginationDto = new PaginationDTO();
		Integer totalCount = questionMapper.countByUserId(userID);
		paginationDto.setPagination(totalCount,page,size);
		if(page < 1) {
			page = 1;
		}
		else if(page>paginationDto.getTotalPage()) {
			page = paginationDto.getTotalPage();
		}
		page = size*(page-1);		
		List<Question> list = questionMapper.listByUserID(userID,page,size);
		List<QuestionDTO> questionDtoList = new ArrayList<QuestionDTO>();
		for(Question question:list) {
			User user = userMapper.findById(question.getCreator());
			QuestionDTO questionDto = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDto);
			questionDto.setUser(user);
			questionDtoList.add(questionDto);
		}		
		paginationDto.setQuestion(questionDtoList);
		return paginationDto;
		
	}
}
