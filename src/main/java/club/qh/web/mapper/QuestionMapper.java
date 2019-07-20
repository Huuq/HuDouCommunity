package club.qh.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import club.qh.web.Model.Question;

@Mapper
public interface QuestionMapper {
	@Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
	void createQuestion(Question question);
    @Select("select * from question")
	List<Question> listQuestion();
}
