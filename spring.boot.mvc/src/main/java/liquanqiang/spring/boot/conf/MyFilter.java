package liquanqiang.spring.boot.conf;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

//使用注解,如下,另外加上此注解@ServletComponentScan
//另外一种方式,使用FilterRegistrationBean和@bean
@WebFilter(urlPatterns="/*")
@Order(1)
public class MyFilter extends GenericFilterBean{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		log.info("begin dofilter");
		chain.doFilter(request, response);
		log.info("end dofilter");
		
	}



}
