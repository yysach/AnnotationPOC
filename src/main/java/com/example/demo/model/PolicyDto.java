package com.example.demo.model;

public class PolicyDto implements BaseDto{
	
	private Integer policyId;
	
	private String policyName;
	
	private Integer priority;
	
	
	public PolicyDto() {
		super();
	}


	public PolicyDto(Integer policyId, String policyName, Integer priority) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.priority = priority;
	}


	public Integer getPolicyId() {
		return policyId;
	}


	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}


	public String getPolicyName() {
		return policyName;
	}


	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	@Override
	public String toString() {
		return "PolicyDto [policyId=" + policyId + ", policyName=" + policyName + ", priority=" + priority + "]";
	}
	
	
	
	
	
	

}
