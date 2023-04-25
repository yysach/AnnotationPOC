package com.example.demo.model;

import com.example.demo.annotation.VersionedResource;

@VersionedResource(from = 10)
public class AnotheHostDto {

	private Integer configId;
	private String hostName;
	public AnotheHostDto(Integer configId, String hostName) {
		super();
		this.configId = configId;
		this.hostName = hostName;
	}
	public AnotheHostDto() {
		super();
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
		return "AnotheHostDto [configId=" + configId + ", hostName=" + hostName + "]";
	}
	
}
