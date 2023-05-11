package com.example.demo;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.example.demo.annotation.requestMapping.VersionRequestMappingHandlerMapping;
import com.example.demo.helper.IVersionRepository;
import com.example.demo.helper.VersionDao;

@Configuration
@ComponentScan("com.example.demo")
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
    	VersionRequestMappingHandlerMapping apiVersioningRequestMappingHandlerMapping = new VersionRequestMappingHandlerMapping();
        apiVersioningRequestMappingHandlerMapping.setOrder(2);
        apiVersioningRequestMappingHandlerMapping.setRemoveSemicolonContent(false);
        return apiVersioningRequestMappingHandlerMapping;
    }
    
	@Bean
	public VersionDao getVersionDaoBean(IVersionRepository versionRepository) {
		return new VersionDao(versionRepository);
	}

}