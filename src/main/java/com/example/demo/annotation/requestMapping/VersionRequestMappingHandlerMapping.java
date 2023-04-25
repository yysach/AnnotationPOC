package com.example.demo.annotation.requestMapping;

import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class VersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
    	System.out.println("customMethodCondition : " + method);
        Version methodAnnotation = AnnotationUtils.findAnnotation(method, Version.class);
        if (methodAnnotation == null) {
        	System.out.println("method annotation not found");
        	return null;
        }
        RequestMapping requestMapping = AnnotatedElementUtils.findMergedAnnotation(method, RequestMapping.class);
        RequestMapping handlerMapping = AnnotatedElementUtils.findMergedAnnotation(method.getDeclaringClass(), RequestMapping.class);
        
        System.out.println("Request Mapping : " + requestMapping);
        System.out.println("Handler Mapping : " + handlerMapping);
        return createCondition(methodAnnotation);
    }

    private RequestCondition<?> createCondition(Version typeAnnotation) {
    	System.out.println("inside createCondition method");
        if (typeAnnotation != null) {
        	System.out.println("createCondition : " + typeAnnotation.from());
            return new VersionedResourceRequestCondition(typeAnnotation.from());
        }
        return null;
    }
    
}
