package club.qh.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.qh.web.Model.Question;
import club.qh.web.Model.QuestionExample;
import club.qh.web.Model.User;
import club.qh.web.dto.PaginationDTO;
import club.qh.web.dto.QuestionDTO;
import club.qh.web.exception.CustomizeErrorCode;
import club.qh.web.exception.CustomizeException;
import club.qh.web.mapper.QuestionExitMapper;
import club.qh.web.mapper.QuestionMapper;
import club.qh.web.mapper.UserMapper;

@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private QuestionExitMapper questionExtMapper;
	
	@Autowired
	private UserMapper userMapper;

	public PaginationDTO listQuestion(Integer page, Integer size) {
		PaginationDTO paginationDto = new PaginationDTO();
		Integer totalCount = (int)questionMapper.countByExample(new QuestionExample());
		paginationDto.setPagination(totalCount,page,size);
		if(page < 1) {
			page = 1;
		}
		else if(page>paginationDto.getTotalPage()) {
			page = paginationDto.getTotalPage();
		}
		page = size*(page-1);		
		List<Question> list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(page, size));
		List<QuestionDTO> questionDtoList = new ArrayList<QuestionDTO>();
		for(Question question:list) {		
			User user = userMapper.selectByPrimaryKey(question.getCreator());					
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
		QuestionExample questionExample = new QuestionExample();
		questionExample.createCriteria().andCreatorEqualTo(userID);
		Integer totalCount = (int)questionMapper.countByExample(new QuestionExample());
		paginationDto.setPagination(totalCount,page,size);
		if(page < 1) {
			page = 1;
		}
		else if(page>paginationDto.getTotalPage()) {
			page = paginationDto.getTotalPage();
		}
		page = size*(page-1);		
		List<Question> list = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds(page, size));
		//List<Question> list = questionMapper.listByUserID(userID,page,size);
		List<QuestionDTO> questionDtoList = new ArrayList<QuestionDTO>();
		for(Question question:list) {
			User user = userMapper.selectByPrimaryKey(question.getCreator());
			QuestionDTO questionDto = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDto);
			questionDto.setUser(user);
			questionDtoList.add(questionDto);
		}		
		paginationDto.setQuestion(questionDtoList);
		return paginationDto;
		
	}

	public QuestionDTO getQuestionDtoById(Integer id) {
		Question question = questionMapper.selectByPrimaryKey(id);
		if(question==null) {
			throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
		}
		QuestionDTO questionDto = new QuestionDTO();
		BeanUtils.copyProperties(question, questionDto);
		User user = userMapper.selectByPrimaryKey(question.getCreator());
		questionDto.setUser(user);
		// TODO Auto-generated method stub
		return questionDto;
	}

	public void createOrUpdate(Question question) {
		if(question.getId()==null) {
			question.setGmtCreate(System.currentTimeMillis());
			question.setGmtModified(question.getGmtCreate());
			questionMapper.insert(question);		
		}else {
			Question questionupdate = new Question();
			questionupdate.setId(question.getId());			
			questionupdate.setGmtModified(question.getGmtCreate());
			questionupdate.setTitle(question.getTitle());
			questionupdate.setDescription(question.getDescription());
			questionupdate.setTag(question.getTag());
			QuestionExample questionExample = new QuestionExample();
			questionExample.createCriteria().andIdEqualTo(question.getId());
			int update = questionMapper.updateByExample(questionupdate, questionExample);
			if(update!=1) {
				throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
			}
			//questionMapper.updateQuestion(question);
		}
		// TODO Auto-generated method stub		
	}
	public void incView(Integer id) {		
		Question updateQuestion = new Question();		
		updateQuestion.setId(id);
		updateQuestion.setViewCount(1);
		questionExtMapper.incView(updateQuestion);
		// TODO Auto-generated method stub
		
	}
}
