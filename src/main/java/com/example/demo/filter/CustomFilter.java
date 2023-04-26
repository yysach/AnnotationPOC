package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.filter.cache.MultiReadHttpServletRequest;


@Component
@Order(1)
public class CustomFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/* wrap the request in order to read the inputstream multiple times */
		System.out.println("---------Filtering---------");
	    MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);

	    /* here I read the inputstream and do my thing with it; when I pass the
	     * wrapped request through the filter chain, the rest of the filters, and
	     * request handlers may read the cached inputstream
	     */
	    chain.doFilter(multiReadRequest, response);
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
	
}
