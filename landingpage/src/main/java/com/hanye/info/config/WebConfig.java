package com.hanye.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		 return new WebMvcConfigurer() {
	            public void addCorsMappings(CorsRegistry registry) {
	            	
	                registry.addMapping("/**")
	                        .allowCredentials(true)
	                        .allowedOrigins("localhost:80")
	                        .maxAge(3600)
	                        .allowedMethods("GET", "POST", "PUT", "DELETE");
	                
	            }
	        };
    }
}
