package com.example.demo;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.example.demo.annotation.requestMapping.VersionRequestMappingHandlerMapping;

@Configuration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
    	VersionRequestMappingHandlerMapping apiVersioningRequestMappingHandlerMapping = new VersionRequestMappingHandlerMapping();
        apiVersioningRequestMappingHandlerMapping.setOrder(1);
        apiVersioningRequestMappingHandlerMapping.setRemoveSemicolonContent(false);
        return apiVersioningRequestMappingHandlerMapping;
    }

}