package in.OAndM.config;

import java.awt.PageAttributes.MediaType;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/**")  // Allow CORS for all endpoints
          
          .allowedOrigins("http://localhost:3002", "http://192.168.1.122:3002","http://localhost:3000")// Allow requests from the front-end app
          .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS") // Allowed HTTP methods
          .allowedHeaders("*") // Allow all headers
          .allowCredentials(true); // Allow credentials like cookies or authorization headers
	}
}