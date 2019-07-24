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

import club.qh.web.Model.User;
import club.qh.web.dto.AccessTokenDTO;
import club.qh.web.dto.GitHubUser;
import club.qh.web.provider.GitHubProvider;
import club.qh.web.service.UserService;

@Controller
public class AuthorizeController {
	
	@Autowired
	private GitHubProvider gitHubProvider;
	@Autowired
	private UserService userService;
	@Value("${github.client.id}")
	private String clientId;
	@Value("${github.client.secret}")
	private String clientSecret;
	@Value("${github.redirect.uri}")
	private String redirectUri;
	@RequestMapping("/callback")
	public String callBack(@RequestParam(name="code")String code,@RequestParam(name="state")String state,
			HttpServletRequest request,HttpServletResponse response
			) {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setCode(code);
		accessTokenDTO.setState(state);
		accessTokenDTO.setRedirect_uri(redirectUri);
		accessTokenDTO.setClient_id(clientId);
		accessTokenDTO.setClient_secret(clientSecret);	
		String accessToken=gitHubProvider.getAccessToken(accessTokenDTO);
		GitHubUser user = gitHubProvider.getUser(accessToken);
		User userInsert = new User();
		String token = UUID.randomUUID().toString();
		userInsert.setToken(token);
		userInsert.setName(user.getName());
		userInsert.setBio(user.getBio());
		userInsert.setAccountId(String.valueOf(user.getId())); 
		userInsert.setGmtCreate(System.currentTimeMillis());
		userInsert.setGmtModified(userInsert.getGmtCreate());
		userInsert.setAvatarUrl(user.getAvatarUrl());
		userInsert.setBlog(user.getBlog());
		userInsert.setCompany(user.getCompany());
		userInsert.setLocation(user.getLocation());
		User userE = userService.createOrUpdate(userInsert);	
		System.out.println(userE.toString());
		//将token放入cookie中
		response.addCookie(new Cookie("token", token));
		request.getSession().setAttribute("user", userE);
		return "redirect:/tohome";		
	}
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		Cookie cookie = new Cookie("token",null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
	    return "redirect:/tohome";	
	}
}
