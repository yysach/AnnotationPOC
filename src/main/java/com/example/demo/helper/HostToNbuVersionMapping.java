package com.example.demo.helper;

import java.util.HashMap;

public class HostToNbuVersionMapping {
	private static HashMap<Integer, Integer> hashMap;
	private HostToNbuVersionMapping() {
	}
	
	public HashMap<Integer, Integer> getMappingInstance(){
		if(hashMap == null) {
			hashMap = new HashMap<Integer, Integer>();
			hashMap.put(123, 10);
			hashMap.put(234, 11);
			hashMap.put(345, 12);
			return hashMap;
		}
		
		return hashMap;
	}
}
