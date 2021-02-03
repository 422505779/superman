package com.lanou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		if(uri.endsWith("login.html") || uri.endsWith("adminLogin") || uri.contains("/js/")||uri.contains("/userbefore/")) {
			chain.doFilter(request, response);
		}else {
			Object obj = req.getSession().getAttribute("admin");
			if(obj!=null) {
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect("login.html");
			}
		}
	}

}
