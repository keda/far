package com.sky.web.controller;

import org.junit.Before;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.sky.config.AppIntegrationTest;


@AppIntegrationTest
public class HomeControllerIntegrationTest {
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Mock
	private HomeController homeController;
	
	@Before
	public void init() {
		
	}
}
