package com.example.demo.filter.cache;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class CachedBodyServletInputStream extends ServletInputStream {

	private final ByteArrayInputStream cachedBodyInputStream;

    public CachedBodyServletInputStream(byte[] cachedBody) {
        this.cachedBodyInputStream = new ByteArrayInputStream(cachedBody);
    }
    
    @Override
    public int read() throws IOException {
        return cachedBodyInputStream.read();
    }
    
    @Override
    public boolean isFinished(){
    	return cachedBodyInputStream.available() == 0;
    }
    
    @Override
    public boolean isReady() {
        return true;
    }
    
    @Override
    public void setReadListener(ReadListener listener) {
    	throw new RuntimeException("Read Listener Not implemented");
    }
}
