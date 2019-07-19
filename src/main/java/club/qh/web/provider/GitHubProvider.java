package club.qh.web.provider;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import club.qh.web.dto.AccessTokenDTO;
import club.qh.web.dto.GitHubUser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/***
 * @Component可以在引用时不需要实例化对象
 * @author nh
 *
 */
@Component
public class GitHubProvider {
   public String getAccessToken(AccessTokenDTO accessTokenDTO) {
    MediaType mediaType  = MediaType.get("application/json; charset=utf-8");

	OkHttpClient client = new OkHttpClient();
	RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
    Request request = new Request.Builder()
      .url("https://github.com/login/oauth/access_token")
      .post(body)
      .build();
   try (Response response = client.newCall(request).execute()) {
       String string = response.body().string();
       String[] spit = string.split("&");
       String tokenstr = spit[0];
       String token = tokenstr.split("=")[1];
	   System.out.println(token);
	   return token;
      } catch (Exception e) {	
		e.printStackTrace();
	}
       return null;
   }
   
   
   public GitHubUser getUser(String access_Token){
	   OkHttpClient client = new OkHttpClient();
	    Request request = new Request.Builder()
	    	      .url("https://api.github.com/user?access_token="+access_Token)
	    	      .build();
	   
	try {
		Response response = client.newCall(request).execute();
		String String = response.body().string();
		GitHubUser gitHubUser=JSON.parseObject(String,GitHubUser.class);
		return gitHubUser;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	return null;	  
   }
   
   
   
}
