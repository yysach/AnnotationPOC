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
		System.out.println(request.getParameter("configId"));
		System.out.println(request.getHeader("configId"));
		System.out.println(obj.getClass().getSimpleName());
		Integer configId = RequestDtoFactory.getInstance(obj.getClass().getSimpleName(), obj);

		if (configId == null) {
			System.out.println("configIdNotFoundException");
			return false;
		}


		System.out.println("checking validation for configId " + configId);
		if(configId >= this.from) return true;
		return false;
	}
	
}
