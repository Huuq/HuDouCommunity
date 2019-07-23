package club.qh.web.mapper;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import club.qh.web.Model.User;

@Mapper
public interface UserMapper {
	@Insert("insert into user(name,accound_id,token,gmt_create,gmt_modified,avatar_url,bio,company,blog,location) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl},#{bio},#{company},#{blog},#{location})")
	void insert(User user);
    @Select("select * from user where token=#{token}")
	User findByToken(@Param("token")String token);
    @Select("select * from user where id=#{id}")
	User findById(@Param("id")Integer id);


}
