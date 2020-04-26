package com.springsec.init;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import com.springsec.service.CustomeAuthenticationSuccesshandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	CustomeAuthenticationSuccesshandler customeAuthenticationSuccesshandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().successHandler(customeAuthenticationSuccesshandler)
		.loginPage("/login")
		.permitAll()
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful")
		.permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
	}

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("ADMIN")
		.and()
		.withUser("test").password("test").roles("USER");
	}
}
