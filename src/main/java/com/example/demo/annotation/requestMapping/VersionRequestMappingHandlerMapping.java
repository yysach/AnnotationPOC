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
        Version methodAnnotation = AnnotationUtils.findAnnotation(method, Version.class);
        if (methodAnnotation == null) {
        	return null;
        }
        return createCondition(methodAnnotation);
    }

    private RequestCondition<?> createCondition(Version typeAnnotation) {
        if (typeAnnotation != null) {
            return new VersionedResourceRequestCondition(typeAnnotation.from());
        }
        return null;
    }
    
}
