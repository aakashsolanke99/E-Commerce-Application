package com.aakash.configuartion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
	
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}

}
