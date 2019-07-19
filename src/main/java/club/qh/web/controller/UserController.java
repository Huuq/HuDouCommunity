package club.qh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

   @RequestMapping("/tohome")
   public String toHome(ModelMap model) {
	   return "index";
   }
	
}
