package com.example.demo.model;

import com.example.demo.annotation.VersionedResource;

public class HostDetailField {
	private Integer hostId;
	
	@VersionedResource(from = 5)
	private Integer configId;
	
	private String hostName;
	
	public HostDetailField() {
		
	}

	public HostDetailField(Integer hostId, Integer configId, String hostname) {
		super();
		this.hostId = hostId;
		this.configId = configId;
		this.hostName = hostname;
	}

	public Integer getHostId() {
		return hostId;
	}

	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostname) {
		this.hostName = hostname;
	}

	@Override
	public String toString() {
		return "HostDetailField [hostId=" + hostId + ", configId=" + configId + ", hostName=" + hostName + "]";
	}
}
