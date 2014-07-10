package com.sky.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.sky.core.AppMessage;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig implements TransactionManagementConfigurer{
	
	Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Autowired
	private AppMessage messageSource;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		Properties jdbc = jdbcProperties();
		
		dataSource.setUsername(jdbc.getProperty("username"));
		dataSource.setPassword(jdbc.getProperty("password"));
		dataSource.setUrl(jdbc.getProperty("url"));
		dataSource.setDriverClassName(jdbc.getProperty("driverClassName"));
		
		return dataSource;
	}
	
	private Properties jdbcProperties() {
		Resource jdbc = appCtx.getResource("classpath:jdbc.properties");
		
		Properties prop = new Properties();
		try {
			prop.load(jdbc.getInputStream());
		} catch (IOException e) {
			LOG.error(messageSource.getMessage("jdbc.error", new String[]{"jdbc.properties"}));
			throw new RuntimeException(e);
		}
		
		return prop;
	}
	
	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}
	
}
