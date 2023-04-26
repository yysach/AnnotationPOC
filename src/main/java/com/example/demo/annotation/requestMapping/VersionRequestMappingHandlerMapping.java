package com.example.demo.annotation.requestMapping;

import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class VersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

	/*
	 * Used for Controller Method level annotation
	 */
    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        Version methodAnnotation = AnnotationUtils.findAnnotation(method, Version.class);
        if (methodAnnotation == null) {
        	return null;
        }
        return createCondition(methodAnnotation);
    }

    /*
     * Used for Controller class level annotation
     */
    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        Version methodAnnotation = AnnotationUtils.findAnnotation(handlerType, Version.class);
        if (methodAnnotation == null) {
        	return null;
        }
        return createCondition(methodAnnotation);
    }
    
    /*
     * get Annotation Mataching condition object
     */
    private RequestCondition<?> createCondition(Version typeAnnotation) {
        if (typeAnnotation != null) {
            return new VersionedResourceRequestCondition(typeAnnotation.from());
        }
        return null;
    }
    
}
