package com.sky.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.sky.core.AppMessage;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class DatabaseConfig implements TransactionManagementConfigurer{
	
	Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Autowired
	private AppMessage messageSource;
	
	@Value("${username}") String username;
	@Value("${password}") String password;
	@Value("${url}") String url;
	@Value("${driverClassName}") String driverClassName;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		
		sqlSessionFactory.setDataSource(dataSource());
		try {
			sqlSessionFactory.setMapperLocations(appCtx.getResources("classpath*:config/mappers/**/*.xml"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return sqlSessionFactory;
		
	}
	
}
