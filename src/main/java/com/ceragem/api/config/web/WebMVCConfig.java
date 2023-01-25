package com.ceragem.api.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ceragem.api.config.intercepter.ApiAuthIntercepter;

/**
 *
 * <pre>
 * com.ceragem.crm.config - WebMVCConfig.java
 * </pre>
 *
 * @ClassName : WebMVCConfig
 * @Description : WebMVC 설정
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

@Configuration
@EnableWebMvc
@ComponentScan({ "com.ceragem" })
public class WebMVCConfig implements WebMvcConfigurer {

	@Autowired
	ApiAuthIntercepter apiAuthIntercepter;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		WebMvcConfigurer.super.addCorsMappings(registry);
		registry.addMapping("/**").allowedOrigins("*");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Packaging resources
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
//				.setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS))
		;
//	        registry.addResourceHandler("/swagger-ui.html")
//	        		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/");
//	        registry.addResourceHandler("/webjars/**")
//            		.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apiAuthIntercepter).addPathPatterns("/api/**").excludePathPatterns("/actuator/**")
				.excludePathPatterns("/static/**").excludePathPatterns("/error/**").excludePathPatterns("/util/**")
				.excludePathPatterns("/swagger-ui.html").excludePathPatterns("/swagger-ui/*")
				.excludePathPatterns("/swagger-resources").excludePathPatterns("/swagger-resources/**")
				.excludePathPatterns("/application/**").excludePathPatterns("/v2/**");
	}

}