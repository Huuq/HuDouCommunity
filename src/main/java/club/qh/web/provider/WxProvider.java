package club.qh.web.provider;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import club.qh.web.dto.WeChatDto;
import club.qh.web.dto.WeChatUser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class WxProvider {

public String getAccessToken(WeChatDto WeChatDto) {
    MediaType mediaType  = MediaType.get("application/json; charset=utf-8");
	OkHttpClient client = new OkHttpClient();
	@SuppressWarnings("deprecation")
	RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(WeChatDto));
    Request request = new Request.Builder()
      .url("https://api.weixin.qq.com/sns/oauth2/access_token")
      .post(body)
      .build();
   try (Response response = client.newCall(request).execute()) {	   
         String token = response.body().string();
         System.out.println(token);
//       String[] spit = string.split("&");
//       String tokenstr = spit[0];
//       String token = tokenstr.split("=")[1];
//	   System.out.println(token);
	   return token;
      } catch (Exception e) {	
		e.printStackTrace();
	}
       return null;
   }   
   
   public WeChatUser getUser(String access_Token,String openID){
	   OkHttpClient client = new OkHttpClient();
	    Request request = new Request.Builder()
	    	      .url("https://api.weixin.qq.com/sns/userinfo?"
	    	      		+ "access_token="+access_Token
	    	      		+ "&openid="+openID
	    	      		+ "&lang=zh_CN"
	    	      	)
	    	      .build();	   
	try {
		Response response = client.newCall(request).execute();
		String String = response.body().string();
		WeChatUser wechatUser=JSON.parseObject(String,WeChatUser.class);
		System.out.println(wechatUser.toString());
		return wechatUser;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	return null;	  
   }
   
   
   
}