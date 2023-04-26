package com.example.demo.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.RequestDtoFactory;


public class MappingValidator implements ConstraintValidator<VersionedResource, Object>{
	private int from;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(VersionedResource constraintAnnotation) {
		this.from = constraintAnnotation.from();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		// header, requestParam and requestBody all three able to get here...
		System.out.println("-----------Inside validator------------");
		System.out.println(obj.getClass().getSimpleName());
		
    	Integer configIdFromHeader = Integer.parseInt(request.getHeader("configId"));
    	Integer configIdFromParam = Integer.parseInt(request.getParameter("configId"));
		Integer configIdFromRequestBody = RequestDtoFactory.getInstance(obj.getClass().getSimpleName(), obj);
		
    	System.out.println("fromVersion received from RequestBody : " + configIdFromRequestBody);
    	System.out.println("fromVersion set at annotation is  : " + this.from);
    	
		if (configIdFromRequestBody == null) {
			System.out.println("configIdNotFoundException");
			return false;
		}

		if(configIdFromRequestBody >= this.from) return true;
		return false;
	}
}
