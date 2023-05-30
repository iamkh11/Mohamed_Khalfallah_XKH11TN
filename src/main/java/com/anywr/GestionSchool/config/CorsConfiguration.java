package com.anywr.GestionSchool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// Tested with nextJS
@Configuration
public class CorsConfiguration {

	@Bean
	WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "DELETE").allowedOrigins("http://localhost:3000");
	        }
	    };
	}



}
