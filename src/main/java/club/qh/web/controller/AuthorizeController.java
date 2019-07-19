package club.qh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.qh.web.dto.AccessTokenDTO;
import club.qh.web.dto.GitHubUser;
import club.qh.web.provider.GitHubProvider;

@Controller
public class AuthorizeController {
	
	@Autowired
	private GitHubProvider gitHubProvider;
	@Value("$(github.client.id)")
	private String clientId;
	@Value("$(github.client.secret)")
	private String clientSecret;
	@Value("$(github.redirect.uri)")
	private String redirectUri;
	@RequestMapping("/callBack")
	public String callBack(@RequestParam(name="code")String code,@RequestParam(name="state")String state) {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setCode(code);
		accessTokenDTO.setState(state);
		accessTokenDTO.setRedirect_uri(redirectUri);
		accessTokenDTO.setClient_id(clientId);
		accessTokenDTO.setClient_secret(clientSecret);
		String accessToken=gitHubProvider.getAccessToken(accessTokenDTO);
		GitHubUser user = gitHubProvider.getUser(accessToken);
		System.out.println(user);
		return "index";
	}

}
