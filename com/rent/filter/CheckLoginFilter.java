package com.rent.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginFilter implements Filter{
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("dddddddd");
		
		HttpServletRequest request = (HttpServletRequest) req;
		
		HttpSession session = request.getSession();
		
		String url = request.getRequestURI();
		if(!url.contains("LoginAction!login.do")){
			
			if(session.getAttribute("user")==null){
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect("login.jsp");
				return;
			}
		}
		chain.doFilter(req, resp);
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
