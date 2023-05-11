package com.example.demo.helper;

import org.springframework.stereotype.Service;

public class VersionDao {
	
	private IVersionRepository versionRepository;
	
	public VersionDao(IVersionRepository versionRepository) {
		this.versionRepository = versionRepository;
	}
	
	public String getVersion() {
		return this.versionRepository.getVersion();
	}
}
