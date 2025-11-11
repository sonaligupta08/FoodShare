package com.example.FoodShare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FoodShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodShareApplication.class, args);
	}
	
	 @Bean
	    public WebMvcConfigurer webMvcConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addResourceHandlers(ResourceHandlerRegistry registry) {
	                registry.addResourceHandler("/uploads/**")
	                        .addResourceLocations("file:uploads/");
	            }
	        };
	    }

}
