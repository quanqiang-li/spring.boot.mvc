package liquanqiang.spring.boot.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorAdpter implements WebMvcConfigurer{

	@Autowired
	private Myinterceptor myinterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("添加拦截器");
		registry.addInterceptor(myinterceptor).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
