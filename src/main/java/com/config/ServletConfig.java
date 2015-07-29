package com.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MimeType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;




@Configuration
@EnableWebMvc
@ComponentScan("com.test.controller")
public class ServletConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver resolver =
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		super.addViewControllers(registry);
		registry.addViewController("/loginForm").setViewName("loginForm");
		registry.addViewController("/testPostList").setViewName("testPostList");
		
	}
	//json 전송하기 위해서 필요함 
	@Bean
	MappingJackson2HttpMessageConverter jsonConverter(){
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		return jsonConverter;
	}
	
	
	 @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	  }
	 
	 @Bean	
	 public RequestMappingHandlerMapping requestMappingHandlerMapping(){
		 RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
		 
		Object[] interceptors = { new HandlerInterceptorAdapter() {
			@Override
			public boolean preHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler)
					throws Exception {
				request.setCharacterEncoding("utf-8");
				return super.preHandle(request, response, handler);
			}
			@Override
			public void postHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				response.setCharacterEncoding("utf-8");
				super.postHandle(request, response, handler, modelAndView);
			}
		}};
		 
		 requestMappingHandlerMapping.setInterceptors(interceptors);
		 return requestMappingHandlerMapping;
	 }
	
	
}
