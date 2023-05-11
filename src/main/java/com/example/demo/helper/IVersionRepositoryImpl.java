package com.example.demo.helper;

import org.springframework.stereotype.Repository;

@Repository
public class IVersionRepositoryImpl implements IVersionRepository {

	@Override
	public String getVersion() {
		return "This is from version repository";
	}

}
