package com.springsec.service;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomeAuthenticationSuccesshandler implements AuthenticationSuccessHandler
{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
				
		response.setStatus(HttpServletResponse.SC_OK);
		boolean admin=false;
		
		System.out.println("At authentication function");
		
		for(GrantedAuthority auth: authentication.getAuthorities())
		{
			if("ROLE_ADMIN".equals(auth.getAuthority()))
			{
				admin=true;
				break;
			}
		}
		
		if(admin)
		{
			redirectStrategy.sendRedirect(request, response, "/admin");
		}
		else
		
			redirectStrategy.sendRedirect(request, response, "/welcome");
		}
		
	
	
		
}
