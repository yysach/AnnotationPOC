package com.example.demo.model;

public class RequestDtoFactory {

	public static Integer getInstance(String objectType, Object object) {
		if(object instanceof Integer) {
			return (Integer) object;
		}else if(objectType.equals("HostDetail") || objectType.equals("ExtendedHostDetail")) {
			return ((HostDetail) object).getConfigId();
		}else if(objectType.equals("AnotheHostDto")) {
			return ((AnotheHostDto) object).getConfigId();
		}
		
		return null;
	}
}
