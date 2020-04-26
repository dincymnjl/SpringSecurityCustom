package com.springsec.init;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;



import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({"com.springsec"})
@EnableWebMvc
@Import(SecurityConfig.class)

public class WebAppConfig extends WebMvcConfigurerAdapter
{
	/*
	 * @Bean(name = "dataSource") public DriverManagerDataSource dataSource() {
	 * DriverManagerDataSource driverManagerDataSource = new
	 * DriverManagerDataSource();
	 * driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/demosecurity");
	 * driverManagerDataSource.setUsername("root");
	 * driverManagerDataSource.setPassword("root"); return driverManagerDataSource;
	 * }
	 */


	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}
