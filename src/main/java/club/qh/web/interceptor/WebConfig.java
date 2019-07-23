package club.qh.web.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
//@EnableWebMvc使用自定义配置
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private SesstionIntercpter sesstionIntercpter;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sesstionIntercpter).addPathPatterns("/**");

	}	

}
