package com.sky.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.sky.core.AppMessage;

@Configuration
@Import({CoreConfig.class, DatabaseConfig.class, PersistenceConfig.class})
public class AppConfig {
	
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasenames(new String[]{"message", "error"});
		
		return messageSource;
	}
	
	public @Bean AppMessage appMessage() {
		return new AppMessage(messageSource());
	}
	
}
