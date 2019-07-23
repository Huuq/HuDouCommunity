//package club.qh.web.interceptor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//	@Autowired
//	private SesstionIntercpter sesstionIntercpter;
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// TODO Auto-generated method stub
////		List<String> listParhPatters = new ArrayList<String>();
////		listParhPatters.add("/**/fonts/*");
////		listParhPatters.add("/**/*.js");
////		listParhPatters.add("/**/*.jpg");
////		listParhPatters.add("/**/*.png");
////		listParhPatters.add("/**/*.eot");
////		listParhPatters.add("/**/*.svg");
////		listParhPatters.add("/**/*.ttf");
////		listParhPatters.add("/**/*.woff");
////		listParhPatters.add("/**/*.woff2");		
////		registry.addInterceptor(sesstionIntercpter).addPathPatterns("/tohome/");
////		registry.addInterceptor(sesstionIntercpter).addPathPatterns("/**").excludePathPatterns("/login/**",
////				"/static/*");	
//		registry.addInterceptor(sesstionIntercpter).addPathPatterns("/*").excludePathPatterns("/static/**");
//
//	}
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		 registry.addResourceHandler("/static/**").addResourceLocations("classpath:/js/","classpath:/css/","classpath:/fonts/");
//	}
//
//	
//
//}
