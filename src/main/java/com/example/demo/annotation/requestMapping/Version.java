package com.example.demo.annotation.requestMapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {

	int from();
}
