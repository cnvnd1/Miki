package com.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
@ComponentScan("com.test.dao, com.test.service, com.logic")
@PropertySource(value="classpath:entity/jdbc.properties")

public class RootConfig {

	@Value("${jdbc.driver}")
	 String driverClassName;
	@Value("${jdbc.url}")
	 String url;
	@Value("${jdbc.userid}")
	 String userid;
	@Value("${jdbc.passwd}")
	 String passwd;
   
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties(){
	
		PropertySourcesPlaceholderConfigurer configure=
				new PropertySourcesPlaceholderConfigurer();
		return configure;
	}

	@Bean
	public  BasicDataSource dataSource(){
		
		BasicDataSource dataSource = 
				new BasicDataSource();
			
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userid);
		dataSource.setPassword(passwd);
		return dataSource;
	}
	
	@Bean
	public  SqlSessionFactoryBean factoryBean(){
	
		SqlSessionFactoryBean factory
		 = new SqlSessionFactoryBean();
	
		factory.setDataSource(dataSource());
		
		factory.setMapperLocations(new Resource[]
				{
					new ClassPathResource("entity/UserMapper.xml"),
					new ClassPathResource("entity/LocationListMapper.xml"),
					new ClassPathResource("entity/EventMapper.xml")
				}
		
				);
		return factory;
	}
	
	@Bean(name ="sessionTemplete")
	public  SqlSessionTemplate sessionTemplete(){
	
		SqlSessionFactory xxx = null;
		try {
			xxx = factoryBean().getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionTemplate template = new SqlSessionTemplate(xxx);
		return template;
	}
	
}
