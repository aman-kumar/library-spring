package com.aman.libraryspring;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public enum ApplicationConfiguration {
	
	INSTANCE;
	
	private Properties props;
	private ApplicationConfiguration(){
		try {
			props = PropertiesLoaderUtils.loadAllProperties("application.properties");
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public String getValue(String key){
		return props.getProperty(key);
	}
}
