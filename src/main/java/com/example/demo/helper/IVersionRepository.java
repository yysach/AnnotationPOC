package com.example.demo.helper;

import org.springframework.stereotype.Repository;

@Repository
public interface IVersionRepository {
	public String getVersion();
}
