package com.second.group.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		addResourceHandler : 스프링부트에서 확인할 폴더 위치 설정
//		addResourceLocations : 실제 시스템의 폴더 위치, 
		registry.addResourceHandler("/img/**").addResourceLocations("file:///C:/img/");
	}
	
}