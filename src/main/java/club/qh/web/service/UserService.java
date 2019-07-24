package club.qh.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.qh.web.Model.User;
import club.qh.web.Model.UserExample;
import club.qh.web.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
    private UserMapper userMapper;

	public User createOrUpdate(User user) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
		List<User> users = userMapper.selectByExample(userExample);
		if(users.size()==0) {
			user.setGmtCreate(System.currentTimeMillis());
			user.setGmtModified(user.getGmtCreate());
			userMapper.insert(user);
		}
		else {	
			User dbUser = users.get(0);
			User updateUser = new User();
			updateUser.setGmtCreate(System.currentTimeMillis());
			updateUser.setAvatarUrl(user.getAvatarUrl());
			updateUser.setToken(user.getToken());
			updateUser.setName(user.getName());
			UserExample example = new UserExample();
			example.createCriteria().andTokenEqualTo(String.valueOf(dbUser.getId()));
			userMapper.updateByExampleSelective(updateUser, example);
			//userMapper.update(dbUser);
		}	
		UserExample userExampleR = new UserExample();
		userExampleR.createCriteria().andAccountIdEqualTo(user.getAccountId());
		List<User> user1 = userMapper.selectByExample(userExampleR);
		return user1.get(0);		
	}
}
