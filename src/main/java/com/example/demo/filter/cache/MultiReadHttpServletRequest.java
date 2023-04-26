package com.example.demo.filter.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StreamUtils;

public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

	private final HttpServletRequest delegateRequest;
	private byte[] cachedBody;
	
	public MultiReadHttpServletRequest(HttpServletRequest request) throws IOException {
		super(request);
		System.out.println("---inside MultiReadHttpRequest constructure---");
		InputStream requestInputSTream = request.getInputStream();
		
	    /* Cache the inputstream in order to read it multiple times. For
	     * convenience, I use apache.commons IOUtils
	     */
		this.cachedBody = StreamUtils.copyToByteArray(requestInputSTream);
		this.delegateRequest = request;
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
	    return new CachedBodyServletInputStream(this.cachedBody);
	}
	    
	@Override
	public BufferedReader getReader() throws IOException{
	  return new BufferedReader(new InputStreamReader(getInputStream()));
	}
	
	
	public HttpServletRequest getDelegateRequest() {
		return this.delegateRequest;
	}
}