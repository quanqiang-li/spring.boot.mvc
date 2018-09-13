package liquanqiang.spring.boot.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 之前的系列篇中介绍了在SpringBoot中使用过滤器，其实拦截器和过滤器从功能上来说，
 * 拦截器/过滤器所能实现的功能过滤器/拦截器都能够实现。
 * 但是过滤器是java实现的，它需要依赖于Servlet容器，而拦截器是SprignMVC实现的一个机制，
 * 独立于Servlet容器，而且能实现IOC容器中的各个bean。
 * 简单的说：过滤器的urlPattern针对的是所有的请求，而拦截器的urlPattern针对的SpringMVC中的Controller控制器处理的请求，并不会拦截Servlet容器
 * 
 * @author carl
 *
 */
@Component
public class Myinterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 只有返回true才会继续向下执行，返回false取消当前请求
		System.out.println("myinterc prehandler");
		System.out.println("path{}" + request.getServletContext().getContextPath());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
