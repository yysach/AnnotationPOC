package com.example.demo.model;

public class Policy110Dto extends Policy102Dto {
	
	private String client;

	public Policy110Dto() {
		super();
	}

	public Policy110Dto(String client) {
		super();
		this.client = client;
	}

	public Policy110Dto(Integer policyId, String policyName, Integer priority, String schedule,
			String client) {
		super(policyId, policyName, priority, schedule);
		this.client = client;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Policy110Dto [client=" + client + ", getSchedule()=" + getSchedule() + ", getPolicyId()="
				+ getPolicyId() + ", getPolicyName()=" + getPolicyName() + ", getPriority()=" + getPriority() + "]";
	}

}
