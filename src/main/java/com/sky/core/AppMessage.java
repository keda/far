package com.sky.core;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class AppMessage {
	
	private MessageSource messageSource;
	
	private Locale locale = null;
	
	public AppMessage(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public AppMessage(MessageSource messageSource, Locale locale) {
		this.messageSource = messageSource;
		this.locale = locale;
	}
	
	public String getMessage(String code, String...args) {
		return messageSource.getMessage(code, args, locale);
	}
	
	public String getMessage(String code, String defaultValue, String...args) {
		return messageSource.getMessage(code, args, defaultValue, locale);
	}
}
