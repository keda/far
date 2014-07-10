package com.sky.config;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class PersistenceIntegrationTest {
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Test
	public void thatDataSource() {
		DataSource dataSource = (DataSource) appCtx.getBean("dataSource");
		
		Assert.assertNotNull(dataSource);
	}
	
}
