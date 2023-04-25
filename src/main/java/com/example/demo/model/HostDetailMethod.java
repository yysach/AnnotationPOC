package com.example.demo.model;

import com.example.demo.annotation.VersionedResource;

public class HostDetailMethod {
	private Integer hostId;
	private Integer configId;
	private String hostName;
	
	@Override
	public String toString() {
		return "HostDetailMethod [hostId=" + hostId + ", configId=" + configId + ", hostName=" + hostName + "]";
	}

	public HostDetailMethod() {
		
	}
	
	public HostDetailMethod(Integer hostId, Integer configId, String hostName) {
		this.hostId = hostId;
		this.configId = configId;
		this.hostName = hostName;
	}

	public Integer getHostId() {
		return hostId;
	}

	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}

	@VersionedResource(from = 6)
	public Integer getConfigId() {
		return configId;
	}

	
	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	
	

}
