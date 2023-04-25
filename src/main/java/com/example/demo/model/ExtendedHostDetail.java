package com.example.demo.model;

import com.example.demo.annotation.VersionedResource;

@VersionedResource(from = 10)
public class ExtendedHostDetail extends HostDetail{
	private String hostType;

	public ExtendedHostDetail() {
		super();
	}

	public ExtendedHostDetail(String hostType) {
		super();
		this.hostType = hostType;
	}

	public String getHostType() {
		return hostType;
	}

	public void setHostType(String hostType) {
		this.hostType = hostType;
	}

	@Override
	public String toString() {
		return "ExtendedHostDetail [hostType=" + hostType + "]";
	}
}
