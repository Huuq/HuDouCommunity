 package club.qh.web.controller;

import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.qh.web.dto.WeChatDto;
import club.qh.web.dto.WeChatUser;
import club.qh.web.provider.WxProvider;



@Controller
public class AuthWeChatController{
	
	@Autowired
	private WxProvider WeChatProvider;
//	@Autowired
//	private UserMapper userMapper;
	@Value("$(wx.appid)")
	private String appid;
	@Value("$(wx.grantType)")
	private String grantType;
	@Value("$(wx.secret)")
	private String secret;
	@RequestMapping("/callbackWeChatLogin")
	public String callBack(@RequestParam(name="code")String code,@RequestParam(name="code")String openID,@RequestParam(name="state")String state,
			HttpServletRequest request,HttpServletResponse response
			) {
		WeChatDto WeChatDto = new WeChatDto();
		WeChatDto.setCode(code);
		WeChatDto.setAppid(appid);
		WeChatDto.setGrantType(grantType);
		WeChatDto.setSecret(secret);
		String accessToken=WeChatProvider.getAccessToken(WeChatDto);
		System.out.println(accessToken);
		WeChatUser user = WeChatProvider.getUser(accessToken,openID);
		System.out.println(user);
	    return "redirect:/index";		
	}
}
