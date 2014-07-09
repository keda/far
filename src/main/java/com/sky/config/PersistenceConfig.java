package com.sky.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class PersistenceConfig {
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Bean
	public DataSource dataSource() throws IOException {
		BasicDataSource dataSource = new BasicDataSource();
		
		Properties jdbc = jdbcProperties();
		
		dataSource.setUsername(jdbc.getProperty("username"));
		dataSource.setPassword(jdbc.getProperty("password"));
		dataSource.setUrl(jdbc.getProperty("url"));
		dataSource.setDriverClassName(jdbc.getProperty("driverClassName"));
		
		return dataSource;
	}
	
	public Properties jdbcProperties() throws IOException {
		Resource jdbc = appCtx.getResource("classpath:jdbc.properties");
		
		Properties prop = new Properties();
		prop.load(jdbc.getInputStream());
		
		return prop;
	}
	
}
