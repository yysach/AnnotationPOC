package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.requestMapping.Version;
import com.example.demo.helper.IVersionRepository;
import com.example.demo.model.AnotheHostDto;
import com.example.demo.model.ExtendedHostDetail;
import com.example.demo.model.HostDetail;
import com.example.demo.model.HostDetailField;
import com.example.demo.model.HostDetailMethod;

@RestController
public class TestController {

	@Autowired
	private IVersionRepository repository;
	/*
	 * Using VersionMappingValidator
	 */
	@RequestMapping(value = "/home/class", method = RequestMethod.GET)
	public String getHomeClassType(@RequestBody @Valid HostDetail hostDetail) {
		System.out.println("From controller " + hostDetail);
		return "this is the class page";
	}
	
	/*
	 * Using VersionMappingValidator
	 */
	@RequestMapping(value = "/home/another/class", method = RequestMethod.GET)
	public String getHomeClassType2(@RequestBody @Valid AnotheHostDto hostDetail) {
		System.out.println("From controller " + hostDetail);
		return "this is the another class page";
	}
	
	/*
	 * Using VersionMappingValidator
	 */
	@RequestMapping(value = "/home/class/extend", method = RequestMethod.GET)
	public String getHomeClassExdType(@RequestBody @Valid ExtendedHostDetail hostDetail) {
		System.out.println("From controller " + hostDetail);
		return "this is the class extended page";
	}
	
	/*
	 * Using VersionMappingValidator
	 */
	@RequestMapping(value = "/home/method", method = RequestMethod.GET)
	public String getHomeMethodType(@RequestBody @Valid HostDetailMethod hostDetail) {
		System.out.println("From controller " + hostDetail);
		return "this is the method page";
	}
	
	/*
	 * Using VersionMappingValidator
	 */
	@RequestMapping(value = "/home/field", method = RequestMethod.GET)
	public String getHomeFieldType(@RequestBody @Valid HostDetailField hostDetail) {
		System.out.println("From controller " + hostDetail);
		return "this is the field page";
	}
	
	/*
	 * Using VersionRequestMappingHandlerCondition
	 */
	@RequestMapping(value = "/home/requestMapping", method = RequestMethod.GET)
	@Version(from = 8)
	public String getHomeGetRequestMapping(@RequestBody HostDetail hostDetail) {
		/*
		 * will only able to get here
		 * if sent configId in requestDto is greater than or equals to mentioned at @Version
		 */
		System.out.println(repository.getVersion());
		System.out.println("HostDetails from requestMapping : " + hostDetail);
		return "this is the home requestMapping page";
	}
}
