package club.qh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeChatController {
   @RequestMapping("/weChatindex")
   public String toWeChatLogin() {
	   return "wechat";
   }
}
