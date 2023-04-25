package com.example.demo.model;

import com.example.demo.annotation.VersionedResource;


@VersionedResource(from = 7)
public class HostDetail {
	private Integer hostId;

	private Integer configId;
	
	private String hostName;
	
	public HostDetail() {
		
	}
	
	public HostDetail(Integer hostId, Integer configId, String hostName) {
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

	@Override
	public String toString() {
		return "HostDetail [hostId=" + hostId + ", configId=" + configId + ", hostName=" + hostName + "]";
	}
	
	
}
