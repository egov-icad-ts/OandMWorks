package in.OAndM.config;

import java.awt.PageAttributes.MediaType;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**").allowedMethods("OPTIONS", "GET", "POST", "PUT",
	 * "DELETE") .allowedOrigins("http://localhost:3000",
	 * "http://192.168.1.122:3002",
	 * "http://localhost:3002","http://192.168.1.122:3002"); // React // app // URL
	 * }
	 * 
	 * }
	 */
}