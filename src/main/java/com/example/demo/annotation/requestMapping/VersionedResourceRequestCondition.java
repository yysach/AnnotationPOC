package com.example.demo.annotation.requestMapping;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.mvc.condition.AbstractRequestCondition;

import com.example.demo.helper.VersionDao;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class VersionedResourceRequestCondition extends AbstractRequestCondition<VersionedResourceRequestCondition> {

    private Integer fromVersion;
    
    public VersionedResourceRequestCondition(int from) {
    	this.fromVersion = from;
    }

    @Override
    public VersionedResourceRequestCondition combine(VersionedResourceRequestCondition other) {
    	System.out.println("under combine method...");
        	/*
           * VersionedResource annotation is allowed only at method level.
           * So, there shouldn't be any case for combine.
           */
    	return new VersionedResourceRequestCondition(fromVersion);
    }

    @Override
    public VersionedResourceRequestCondition getMatchingCondition(HttpServletRequest request) {
    	// header, requestParam and requestBody all three able to get here...
    	System.out.println("-------inside getMatchingCondition---------");
    	Integer configIdFromHeader = Integer.parseInt(request.getHeader("configId"));
    	Integer configIdFromParam = Integer.parseInt(request.getParameter("configId"));
    	Integer configIdFromRequestBody = readFromHttpServletRequest(request);

    	System.out.println("fromVersion received from RequestBody : " + configIdFromRequestBody);
    	System.out.println("fromVersion set at annotation condition is  : " + this.fromVersion);
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	context.scan("com.example.demo.helper");
    	context.refresh();
    			
    	//Getting Bean by Class
    	VersionDao repository = context.getBean(VersionDao.class);
    	System.out.println("Version : " + repository.getVersion());
    	
		if (configIdFromRequestBody == null) {
			System.out.println("configIdNotFoundException");
			return null;
		}
		
    	if(configIdFromRequestBody >= this.fromVersion) return this;
    	return null;
    }

    @Override
    public int compareTo(VersionedResourceRequestCondition other, HttpServletRequest request) {
        /*
         * Compare this condition to another condition in the context of a specific request.
         * This method assumes both instances have been obtained via getMatchingCondition(HttpServletRequest)
         * to ensure they have content relevant to current request only.
         *
         * For our use case, we do not want multiple instances passing getMatchingCondition.
         * So, we would return 0 - which would indicate to spring that both the conditions are applicable.
         * In which case, spring would flag it as conflicting specification resulting in exception.
         */
    	System.out.println("Inside of VersionRequestMappingHandler compareTo..");
        return 0;
    }

    @Override
    protected Collection<?> getContent() {
        /*
         * Return the discrete items a request condition is composed of.
         */
        return (fromVersion == null) ? Collections.emptyList() : Collections.singletonList(fromVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VersionedResource={");
        if (fromVersion != null) {
            sb.append(String.valueOf(fromVersion));
        }
        sb.append("}");
        System.out.println("api versionedResourced : " + sb.toString());
        return sb.toString();
    }

    @Override
    protected String getToStringInfix() {
        /*
         * The notation to use when printing discrete items of content.
         */
        return " || ";
    }
    
	private Integer readFromHttpServletRequest(HttpServletRequest request) {
		BufferedReader reader = null;
		ObjectMapper mapper = null;
		try {
			reader = request.getReader();
			mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(reader);
			System.out.println("Read RequestBody : " + node.toPrettyString());
			return Integer.valueOf(node.get("configId").asText());
		} catch (Exception e) {
			System.out.println("Got exception while reading HttpServletRequest reader" + e);
		}
		return null;
	}
}