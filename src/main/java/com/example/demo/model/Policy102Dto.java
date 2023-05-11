package com.example.demo.model;

public class Policy102Dto extends PolicyDto {

	private String schedule;

	
	public Policy102Dto() {
		super();
	}


	public Policy102Dto(String schedule) {
		super();
		this.schedule = schedule;
	}


	public Policy102Dto(Integer policyId, String policyName, Integer priority, String schedule) {
		super(policyId, policyName, priority);
		this.schedule = schedule;
	}


	public String getSchedule() {
		return schedule;
	}


	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}


	@Override
	public String toString() {
		return "Policy102Dto [schedule=" + schedule + ", getPolicyId()=" + getPolicyId() + ", getPolicyName()="
				+ getPolicyName() + ", getPriority()=" + getPriority() + "]";
	}
	
	
	
}
